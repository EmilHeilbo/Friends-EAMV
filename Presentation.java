package dev.yukie.friends;

import java.util.Scanner;

import static dev.yukie.friends.FriendsLogic.*;

public class Presentation {
    Scanner scan = new Scanner(System.in);

    public void main(String[] args) {
        mainMenu();
    }

    void mainMenu() {
        do {
            System.out.print("Please select an option:\n(C)reate, (R)ead, (U)pdate, (D)elete, (E)xit:\t");
            char input = scan.nextLine().toLowerCase().charAt(0);   //Possible nullPointerException()?
            switch (input) {
                case 'c' -> createFriend();
                case 'r' -> listFriends();
                case 'u' -> updateFriend();
                case 'd' -> deleteFriend();
                case 'e' -> exit();
                default -> System.out.println("Input invalid.");
            }
        } while (true);
        //Create example:
        createFriend();
    }

    void exit() {
        return 0;
    }
}
