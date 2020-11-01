package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import logic.Friend;

public class FriendObject extends AbstractListData<Friend> {


    public FriendObject(String uri) throws IOException {
        super(uri);
    }

    public FriendObject(AbstractListData<Friend> data){
        super(data);
    }

    public FriendObject(ListData<Friend> data) {
        this((AbstractListData<Friend>) data);
	}

	@Override
    public void commit() throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(uri))) {
            oos.writeObject(data);
        }
    }

    // Deserialazation can be insecure and exploited for arbitrary code execution if no means of safty is made.
    @SuppressWarnings("unchecked")
    @Override
    public void rollback() throws IOException {
        var file = new File(uri);
        file.createNewFile();
        try (var ois = new ObjectInputStream(new FileInputStream(file))) {
            data = (List<Friend>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
