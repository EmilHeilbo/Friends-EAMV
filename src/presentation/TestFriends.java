package presentation;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

import logic.Friend;
import logic.FriendsFactory;
import logic.Group;
import logic.Interest;
import logic.SaveStrategy;

public class TestFriends {
    public static void main(String[] args) throws IOException {
        // Does only work when using one test at a time, idk why.
        //test("friendData.CVS",SaveStrategy.CVS);
        test("friendData.Object",SaveStrategy.Object);
    }

    public static void test(String uri, SaveStrategy format) throws IOException {
        // Delete file if it exists,
        new File(uri).delete();
        var friendsFactory = new FriendsFactory(uri, format);
        var friends = friendsFactory.provide();

        // Create Hans, Search eamv, expect Hans.
        var hans = new Friend("Hans", "hi@eamv.dk", "70457823", Group.Acquaintance,
                new TreeSet<Interest>(Arrays.asList(Interest.Fishing, Interest.Chess)));
        friends.create(hans);
        var searchResult = friends.search("eamv");
        System.out.println("Expect: Hans");
        searchResult.forEach(System.out::println);

        // Create Mads, Search eamv, expect Hans, Mads
        var mads = new Friend("Mads", "hi@eamv.dk", "70459943", Group.Foe,
                new TreeSet<Interest>(Arrays.asList(Interest.CSGO, Interest.Photography)));
        friends.create(mads);
        var searchResult2 = friends.search("eamv");
        System.out.println("Expect: Hans og Mads");
        searchResult2.forEach(System.out::println);

        // Create Lone, Search ads, expect Mads
        var lone = new Friend("Lone", "lo@eamv.dk", "70454541", Group.Friend,
                new TreeSet<Interest>(Arrays.asList(Interest.Cooking, Interest.Animals)));
        friends.create(lone);
        var searchResult3 = friends.search("ads");
        System.out.println("Expect: Mads");
        searchResult3.forEach(System.out::println);

        // Search eamv, expect Hans, Mads, Lone
        var searchResult4 = friends.search("eamv");
        System.out.println("Expect: Hans, Mads, Lone");
        searchResult4.forEach(System.out::println);
    }
}
