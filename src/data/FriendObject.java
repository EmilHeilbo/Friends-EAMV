package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logic.Friend;

public class FriendObject extends AbstractListData<Friend> {


    public FriendObject(String uri) {
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

    // TODO - read up on ObjectInputStream usage.
    @Override
    public void rollback() throws IOException {
        try (var ois = new ObjectInputStream(new FileInputStream(uri))) {
        }
    }
}
