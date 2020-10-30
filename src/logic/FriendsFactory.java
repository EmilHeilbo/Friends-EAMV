package logic;

public class FriendsFactory {
    private static Friends impl;

    public FriendsFactory(String uri, SaveStrategy format) {
        if (impl == null)
            impl = new FriendsImpl(uri, format);
    }

    public Friends provide() {
        return impl;
    }
}