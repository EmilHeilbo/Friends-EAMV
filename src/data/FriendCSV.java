package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

import logic.Friend;
import logic.Group;
import logic.Interest;

public class FriendCSV extends AbstractListData<Friend> {

    public FriendCSV(String uri) throws IOException {
        super(uri);
    }

    public FriendCSV(AbstractListData<Friend> data) {
        super(data);
    }

    @Override
    public void commit() throws IOException {
        try (var pw = new PrintWriter(uri)) {
            pw.println("group;name;email;mobile;interests");
            data.forEach(e -> pw.println(e.group().name() + ";" + e.name() + ";" + e.email() + ";" + e.mobile()
                    + ";" + e.interests().stream().map(Interest::name).collect(Collectors.joining(","))));
        }
    }

    @Override
    public void rollback() throws IOException {
        var file = new File(uri);
        file.createNewFile();
        data.clear();
        try (var br = new BufferedReader(new FileReader(file))) {
            br.lines().skip(1).forEach(e -> {
                var f = e.split(";");
                var i = Arrays.stream(f[4].split(",")).map(s -> Interest.valueOf(s)).collect(Collectors.toSet());
                data.add(new Friend(f[1], f[2], f[3], Group.valueOf(f[0]), i));
            });
        }
    }
}
