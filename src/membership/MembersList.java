package membership;

import csvhandler.CSVMembership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembersList {
    private final List<Membership> memberslist = new ArrayList<>();

  public List<Membership> getMembersList() {
        return memberslist;
    }

    //Metode til at oprette medlemmer
    public void createMember() {
        //Ny Arrayliste til at lagre CSV filens data til at generere ID nummer ud fra Arraylistens index
        List<Membership> getIDArray = new ArrayList<>();
        CSVMembership reader = new CSVMembership();

        //Læser CSV filens data til 'memberslist' Arraylisten.
        reader.readCSV("src/CSVFiles/MembersList.CSV", getIDArray);

        //Ny Arrayliste til at lagre et nyt medlem
        List<Membership> createMember = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //Gemmer 'memberslist' størrelse af index + 1
        int ID = getIDArray.size() + 1;

        //Gemmer navn
        System.out.print("Navn: ");
        String name = scanner.nextLine();

        //Gemmer alder
        System.out.print("Alder: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        //Gemmer aktiv
        System.out.print("Er medlemmet aktivt? (j/n): ");
        String choiceAP = scanner.nextLine().trim().toLowerCase();
        boolean active = false;
        while (!choiceAP.equals("j") && !choiceAP.equals("n")) {
            System.out.println("tast j/n");
            choiceAP = scanner.nextLine().trim().toLowerCase();
        }
        if (choiceAP.equals("j")) {
            active = true;
        }

        //Gemmer restance
        System.out.print("Er medlemmet i restance? (j/n): ");
        String choiceRes = scanner.nextLine().trim().toLowerCase();
        boolean debt = false;
        while (!choiceRes.equals("j") && !choiceRes.equals("n")) {
            System.out.println("tast j/n");
            choiceRes = scanner.nextLine().trim().toLowerCase();
        }
        if (choiceRes.equals("j")) {
            debt = true;
        }

        //Gemmer hobby
        System.out.print("Er medlemmet konkurrencesvømmer? (j/n): ");
        String choiceComp = scanner.nextLine().trim().toLowerCase();
        boolean competitive = false;
        while (!choiceComp.equals("j") && !choiceComp.equals("n")) {
            System.out.println("tast j/n");
            choiceComp = scanner.nextLine().trim().toLowerCase();
        }
        if (choiceComp.equals("j")) {
            competitive = true;
        }
        //Tildeler de gemte variabler til et Membership objekt, og tilføjer det til 'opretmedlem' Arraylisten
        createMember.add(new Membership(ID, name, age, active, debt, competitive));

        //Skriver 'opretmedlem' listen ind i CSV filen
        CSVMembership writer = new CSVMembership();
        writer.writeCSV("src/CSVFiles/MembersList.CSV", createMember);

        System.out.println("Medlem oprettet.");

    }

    //Viser medlemmer metode
    public void showMembers() {

        //Ny Arrayliste 'visListe' til at vise medlemmer som er gemt i CSV filen
        List<Membership> visListe = new ArrayList<>();

        //Her læses filen, og konverterer linjerne til ArrayListen
        CSVMembership reader = new CSVMembership();
        reader.readCSV("src/CSVFiles/MembersList.CSV", visListe);

        //For loop til at vise medlemmer
        for (Membership m : visListe) {
            System.out.println(m);

        }
        System.out.println("\n_____________________" +
                "\nAntallet af medlemmer i alt: " + visListe.size() +
                "\n_____________________");
    }

    public void showExpectedPayments() {
        List<Membership> list = new ArrayList<>(); // Laver tom array
        CSVMembership reader = new CSVMembership();
        reader.readCSV("src/CSVFiles/MembersList.CSV", list); // Læser fra CSV til tom array

        double total = 0;
        double totalDebt = 0;

        for (Membership m : list) {
            double fee = m.expectedFee();// gennemgår medlemmer fra array og udregner samletbetaling
            total += fee;
            if (m.hasDebt()) {
                totalDebt += fee;
            }
        }
        System.out.printf("Samlet forventet kontingentbetaling: %.2f kr.\n", total, "Inklusiv restance"); //Udskriver beløb i kroner
        System.out.printf("Samlet restance beløb: %.2f kr. \n", totalDebt);
    }

    public void showMembersInDebt() {
        List<Membership> list = new ArrayList<>(); // Laver tom array
        CSVMembership reader = new CSVMembership();
        reader.readCSV("src/CSVFiles/MembersList.CSV", list); // Læser fra CSV til tom array

        //Tæller og viser medlemmer i restance
        int count = 0;
        System.out.println("\n Medlemmer i restance");
        for (Membership m : list) {
            if (m.hasDebt()) {
                System.out.println(m);
                count++;
            }
        }
        System.out.println("_____________________" +
                "\nAntallet af medlemmer i restance: " + count);

    }

}
