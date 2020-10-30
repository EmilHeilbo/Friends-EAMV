package data;

import java.io.IOException;

import logic.Friend;
import logic.SaveStrategy;

public class FriendDataFactory {
    private static FriendDataFactory instance;
    private static ListData<Friend> data;
    private SaveStrategy format;

    public FriendDataFactory(String uri, SaveStrategy format) throws IOException {
        if(instance==null){
            data = new FriendCVS(uri);
            this.format = format;
        }
    }
    public ListData<Friend> provide(){
        return data;
    }

    // TODO - Research more about optimal way to implement SaveStrategy in the data layer.
    // Think about making the different strategies singelton instances?
    public ListData<Friend> provide(SaveStrategy format){
        if(this.format.equals(format)) return data;
        switch(format){
            case CVS -> data = new FriendCVS(data);
            case Object -> data = new FriendObject(data);
			default -> throw new IllegalArgumentException("Unexpected value: " + format);
        }
        this.format = format;
        return data;
    }

}
