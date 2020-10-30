package presentation;

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
        var friendsFactory = new FriendsFactory("friendData.cvs", SaveStrategy.CVS);
        var friends = friendsFactory.provide();



        var hans = new Friend("Hans", "hi@eamv.dk", "70457823", Group.Acquaintance, new TreeSet<Interest>(Arrays.asList(Interest.Fishing, Interest.Chess)));
        friends.create(hans);
        var searchResult = friends.search("eamv");
        System.out.println("Expect: Hans");
        System.out.println("String \"MadsK\" contains String \"ads\": " + "MadsK".contains("ads"));
        System.out.println("Is searchResult empty: " + searchResult.isEmpty());
        searchResult.forEach(System.out::println);


        var mads = new Friend("Mads", "hi@eamv.dk", "70459943", Group.Foe, new TreeSet<Interest>(Arrays.asList(Interest.CSGO, Interest.Photography)));
        friends.create(mads);
        var searchResult2 = friends.search("eamv");
        System.out.println("Expect: Hans og Mads");
        searchResult2.forEach(System.out::println);
        


        var lone = new Friend("Lone", "lo@eamv.dk", "70454541", Group.Friend, new TreeSet<Interest>(Arrays.asList(Interest.Cooking, Interest.Animals)));
        friends.create(lone);
        var searchResult3 = friends.search("ads");
        System.out.println("Expect: Mads");
        searchResult3.forEach(System.out::println);
    }
}
