package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

import logic.Friend;
import logic.Group;
import logic.Interest;

public class FriendCVS extends AbstractListData<Friend> {

    public FriendCVS(String uri) throws IOException {
        super(uri);
    }

    public FriendCVS(AbstractListData<Friend> data) {
        super(data);
    }

    public FriendCVS(ListData<Friend> data) {
        this((AbstractListData<Friend>) data);
    }

    @Override
    public void commit() throws IOException {
        try (var pw = new PrintWriter(uri)) {
            pw.println("group;name;email;mobile;interests");
            data.forEach(e -> pw.println(e.group().name() + e.name() + e.email() + e.mobile()
                    + e.interests().stream().map(Interest::name).collect(Collectors.joining(", "))));
        }
    }

    @Override
    public void rollback() throws IOException {
        try (var br = new BufferedReader(new FileReader(uri))) {
            data.clear();
            br.lines().skip(1).forEach(e -> {
                var f = e.split(";");
                var i = Arrays.stream(f[4].split(",")).map(s -> Interest.valueOf(s)).collect(Collectors.toSet());
                data.add(new Friend(f[1], f[2], f[3], Group.valueOf(f[0]), i));
            });
        }
    }
}
