package System;

import Membership.Membership;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      //  UI ui = new UI();
     //   ui.start();

        Scanner input = new Scanner(System.in);

        System.out.print("Navn: ");
        String name = input.nextLine();

        System.out.print("Alder: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Kategori (ung/voksen/pensionist): ");
        String category = input.nextLine();

        System.out.print("Er medlemmet aktivt? (true/false): ");
        boolean active = input.nextBoolean();

        System.out.print("Er medlemmet i restance? (true/false): ");
        boolean debt = input.nextBoolean();

        System.out.print("Er medlemmet konkurrencesvømmer? (true/false): ");
        boolean competitive = input.nextBoolean();

        ArrayList<Membership> memberslist = new ArrayList<>();

        memberslist.add(new Membership(name, age, category, active, debt, competitive));

        for(Membership m : memberslist){
            System.out.println(m);
        }

    }

}