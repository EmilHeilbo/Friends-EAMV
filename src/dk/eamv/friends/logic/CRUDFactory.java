package dk.eamv.friends.logic;

public class CRUDFactory {
    public CRUD createFriends() {
        return new CRUDImpl();
    }
}