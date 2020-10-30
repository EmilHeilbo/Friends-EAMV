package logic;

import java.io.IOException;

public class FriendsFactory {
    private static Friends impl;

    public FriendsFactory(String uri, SaveStrategy format) throws IOException {
        if (impl == null)
            impl = new FriendsImpl(uri, format);
    }

    public Friends provide() {
        return impl;
    }
}