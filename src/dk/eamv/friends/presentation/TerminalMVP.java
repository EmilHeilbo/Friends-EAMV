package dk.eamv.friends.presentation;

import dk.eamv.friends.logic.CRUDImpl;

import java.util.Scanner;

public class TerminalMVP {
    static Scanner sc = new Scanner(System.in);
    static CRUDImpl crud = new CRUDImpl();

    public static void main(String[] args) {
        EXIT:
        for (;;) {
            System.out.println("Welcome to the program.\n(C)reate, (R)ead, (U)pdate, (D)elete, (E)xit: ");
            switch (sc.nextLine().toLowerCase()) {
                case "c" -> crud.create();
                case "r" -> crud.read();
                case "u" -> crud.update();
                case "d" -> crud.delete();
                case "e" -> {
                    break EXIT;
                }
                default -> System.out.println("Unexpected input.");
            }
        }
    }
}
