package logic;

import java.io.IOException;

public class FriendsFactory {
    private static volatile FriendsFactory instance;
    private static Friends impl;

    /**
     * Singelton Factory for Friends
     */
    private FriendsFactory(String uri, SaveStrategy format) throws IOException {
        if (impl == null)
            impl = new FriendsImpl(uri, format);
    }

    public static FriendsFactory getInstance(String uri, SaveStrategy format) throws IOException {
        if (instance == null)
            synchronized (FriendsFactory.class) {
                if (instance == null)
                    instance = new FriendsFactory(uri, format);
            }
        return instance;
    }

    public Friends provide() {
        return impl;
    }
}