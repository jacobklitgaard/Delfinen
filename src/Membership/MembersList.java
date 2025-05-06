package Membership;

import CSVHandler.CSVMembership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembersList {
    private final List<Membership> memberslist = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    //opretter metode
    public void opretMedlem () {
        System.out.print("Navn: ");
        String name = input.nextLine();

        System.out.print("Alder: ");
        int age = input.nextInt();
        input.nextLine();

//        System.out.print("Kategori (ung/voksen/pensionist): ");
//        String category = input.nextLine();

        System.out.print("Er medlemmet aktivt? (true/false): ");
        boolean active = input.nextBoolean();

        System.out.print("Er medlemmet i restance? (true/false): ");
        boolean debt = input.nextBoolean();

        System.out.print("Er medlemmet konkurrencesvømmer? (true/false): ");
        boolean competitive = input.nextBoolean();

        memberslist.add(new Membership(name, age, active, debt, competitive));

        //Her skrives objektet ind i MemberList.CSV filen
        CSVMembership writer = new CSVMembership();
        writer.writeCSV("src/CSVFiles/MembersList.CSV", memberslist);
    }
    //Viser medlemmer metode
    public void visMedlemmer() {
        //Her læses filen, og konvertere linjerne til ArrayListen
        CSVMembership reader = new CSVMembership();
        reader.readCSV("src/CSVFiles/MembersList.CSV", memberslist);
        //For loop til at vise medlemmer
        for(Membership m : memberslist){
            System.out.println(m);
        }
    }

}
