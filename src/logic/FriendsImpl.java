package logic;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import data.FriendDataFactory;
import data.ListData;

public class FriendsImpl implements Friends, Serializable {

    private static final long serialVersionUID = 202000000001L;
    private FriendDataFactory dataFactory;
    private ListData<Friend> data;
    private String uri;
    private SaveStrategy format;

    public FriendsImpl(String uri, SaveStrategy format) throws IOException {
        this.uri = uri;
        this.format = format;
        dataFactory = new FriendDataFactory(uri, format);
        data = dataFactory.provide();
    }

    @Override
    public boolean create(Friend friend) {
        var res = data.add(friend);
        if (res)
            transaction();
        return res;
    }

    @Override
    public boolean update(Friend friend) {
        for (int i = 0; i < data.size(); i++)
            if (data.get(i).key() == friend.key()) {
                data.set(i, friend);
                transaction();
                return true;
            }
        return false;
    }

    @Override
    public boolean delete(Friend friend) {
        var res = data.remove(friend);
        if (res)
            transaction();
        return res;
    }

    @Override
    public Friend read(int key) {
        for (int i = 0; i < data.size(); i++)
            if (data.get(i).key() == key)
                return data.get(i);
        return null;
    }

    @Override
    public List<Friend> search(String str) {
        var result = new ArrayList<Friend>();
        for (int i = 0; i < data.size(); i++)
            result.add(data.get(i));
        return result.stream().filter(e -> e.toString().contains(str)).collect(Collectors.toList());
    }

    @Override
    public void setURI(String uri) throws IOException {
        if (this.uri != uri) {
            data.setURI(uri);
            this.uri = uri;
        }
    }

    @Override
    public void setSaveStrategy(SaveStrategy format) {
        if (this.format != format) {
            data = dataFactory.provide(format);
            this.format = format;
        }
    }

    public void transaction() {
        try {
            data.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}