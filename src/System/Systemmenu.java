package System;

import Membership.MembersList;

import java.util.Scanner;

public class Systemmenu {
    private final Scanner input = new Scanner(System.in);


    public void Cashier () {

    }

    public void Trainer () {

    }

    public void Chairman () {
        MembersList opretMedlem = new MembersList();
        //UI til Formand
        boolean running = true;
        while (running) {
            System.out.println("Håndtere medlemmer....\n" +
                    "1: Opret medlem\n" +
                    "2: Vis medlemmer\n" +
                    "9: Gå tilbage");
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> opretMedlem.opretMedlem();
                case "2" -> opretMedlem.visMedlemmer();
                case "9" -> running = false;
            }
        }
    }


}