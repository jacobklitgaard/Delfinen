package membership;

import CSVHandler.CSVMembership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembersList {
    private final List<Membership> memberslist = new ArrayList<>();
    private final List<Membership> compMemberslist = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);



    public List<Membership> getMembersList() {
        return memberslist;
    }

    //Metode til at oprette medlemmer
    public void opretMedlem () {
        //Ny Arrayliste til at lagre CSV filens data til at generere ID nummer ud fra Arraylistens index
        List<Membership> getIDArray = new ArrayList<>();
        CSVMembership reader = new CSVMembership();

        //Læser CSV filens data til 'memberslist' Arraylisten.
        reader.readCSV("src/CSVFiles/MembersList.CSV", getIDArray);

        //Ny Arrayliste til at lagre et nyt medlem
        List<Membership> opretmedlem = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //Gemmer 'memberslist' størrelse af index + 1
        int ID = getIDArray.size() + 1;

        //Gemmer navn
        System.out.print("Navn: ");
        String name = input.nextLine();

        System.out.print("Alder: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        //Gemmer aktiv
        System.out.print("Er medlemmet aktivt? (j/n): ");
        String choiceAP = scanner.nextLine().trim().toLowerCase();
        boolean active = false;
        while(!choiceAP.equals("j") && !choiceAP.equals("n")){
            System.out.println("tast j/n");
            choiceAP = scanner.nextLine().trim().toLowerCase();
        }
        if(choiceAP.equals("j")){
            active = true;
        }

        //Gemmer restance
        System.out.print("Er medlemmet i restance? (j/n): ");
        String choiceRes = scanner.nextLine().trim().toLowerCase();
        boolean debt = false;
        while(!choiceRes.equals("j") && !choiceRes.equals("n")){
            System.out.println("tast j/n");
            choiceRes = scanner.nextLine().trim().toLowerCase();
        }
        if(choiceRes.equals("j")){
            debt = true;
        }

        //Gemmer hobby
        System.out.print("Er medlemmet konkurrencesvømmer? (j/n): ");
        String choiceComp = scanner.nextLine().trim().toLowerCase();
        boolean competitive = false;
        while(!choiceComp.equals("j") && !choiceComp.equals("n")){
            System.out.println("tast j/n");
            choiceComp = scanner.nextLine().trim().toLowerCase();
        }
        if(choiceComp.equals("j")){
            competitive = true;
        }
        //Tildeler de gemte variabler til et Membership objekt, og tilføjer det til 'opretmedlem' Arraylisten
        opretmedlem.add(new Membership(ID, name, age, active, debt, competitive));

        //Her skrives objektet ind i MemberList.CSV filen
        CSVMembership writer = new CSVMembership();
        writer.writeCSV("src/CSVFiles/MembersList.CSV", memberslist);
    }


    //Viser medlemmer metode
    public void visMedlemmer() {
        //Her læses filen, og konverterer linjerne til ArrayListen
        CSVMembership reader = new CSVMembership();
        reader.readCSV("src/CSVFiles/MembersList.CSV", memberslist);
        //For loop til at vise medlemmer
        for(Membership m : memberslist){
            System.out.println(m);
        }
    }



}
