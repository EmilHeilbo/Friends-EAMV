package dk.eamv.friends.presentation;

import dk.eamv.friends.logic.Friends;
import java.util.Scanner;

public class TerminalMVP {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var friends = new Friends();

        EXIT:
        for (;;) {
            System.out.println("Welcome to the program.\n(C)reate, (R)ead, (U)pdate, (D)elete, (E)xit: ");
            switch (sc.nextLine().toLowerCase()) {
                case "c" -> friends.create();
                case "r" -> friends.read();
                case "u" -> friends.update();
                case "d" -> friends.delete();
                case "e" -> {break EXIT;}
                default -> System.out.println("Unexpected input.");
            }
        }
    }
}
