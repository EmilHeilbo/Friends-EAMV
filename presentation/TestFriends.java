package presentation;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

import logic.Friend;
import logic.Friends;
import logic.FriendsFactory;
import logic.Group;
import logic.Interest;
import logic.SaveStrategy;

public class TestFriends {
    private static Friends friends;
    private static String uri;
    private static SaveStrategy format;

    public static void main(String[] args) throws IOException {
        uri = "friendData.csv";
        format = SaveStrategy.CSV;
        new File(uri).delete();
        friends = FriendsFactory.getInstance(uri, format).provide();
        test(1);



        System.out.println("\n\n\n");



        uri = "friendData.object";
        format = SaveStrategy.OBJECT;
        new File(uri).delete();
        friends.setSaveStrategy(format);
        friends.setURI(uri);
        test(2);
    }

    public static void test(int testNumber) throws IOException {
        System.out.println("Beginning of Test "+ testNumber + "#");
        var hans = new Friend("Hans", "hi@eamv.dk", "70457823", Group.Acquaintance,
                new TreeSet<Interest>(Arrays.asList(Interest.Fishing, Interest.Chess)));
        friends.create(hans);
        var searchResult = friends.search("eamv");
        System.out.println("Expect: Hans");
        searchResult.forEach(System.out::println);
        System.out.println();

        var mads = new Friend("Mads", "hi@eamv.dk", "70459943", Group.Foe,
                new TreeSet<Interest>(Arrays.asList(Interest.CSGO, Interest.Photography)));
        friends.create(mads);
        var searchResult2 = friends.search("eamv");
        System.out.println("Expect: Hans og Mads");
        searchResult2.forEach(System.out::println);
        System.out.println();

        var lone = new Friend("Lone", "lo@eamv.dk", "70454541", Group.Friend,
                new TreeSet<Interest>(Arrays.asList(Interest.Cooking, Interest.Animals)));
        friends.create(lone);
        var searchResult3 = friends.search("ads");
        System.out.println("Expect: Mads");
        searchResult3.forEach(System.out::println);
        System.out.println();

        var searchResult4 = friends.search("eamv");
        System.out.println("Expect: Hans, Mads, Lone");
        searchResult4.forEach(System.out::println);
        System.out.println("End of Test "+ testNumber + "#");
    }
}
