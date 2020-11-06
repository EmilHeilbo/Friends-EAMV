package data;

import java.io.IOException;

import logic.Friend;
import logic.SaveStrategy;

public class FriendDataFactory {
    private static volatile FriendDataFactory instance;
    private AbstractListData<Friend> data;
    private SaveStrategy format;

    private FriendDataFactory(String uri, SaveStrategy format) throws IOException {
        switch (format) {
            case CSV -> data = new FriendCSV(uri);
            case OBJECT -> data = new FriendOBJECT(uri);
            default -> throw new IllegalArgumentException("Unexpected value: " + format);
        }
        this.format = format;
    }

    public static FriendDataFactory getInstance(String uri, SaveStrategy format) throws IOException {
        if (instance == null)
            synchronized (FriendDataFactory.class) {
                if (instance == null)
                    instance = new FriendDataFactory(uri, format);
            }
        return instance;
    }

    public ListData<Friend> provide() {
        return data;
    }

    public ListData<Friend> provide(SaveStrategy format) {
        if (this.format.equals(format))
            return data;
        switch (format) {
            case CSV -> data = new FriendCSV(data);
            case OBJECT -> data = new FriendOBJECT(data);
            default -> throw new IllegalArgumentException("Unexpected value: " + format);
        }
        this.format = format;
        return data;
    }

}
