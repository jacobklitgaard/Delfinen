package result;

import csvhandler.CSVCompetition;
import csvhandler.CSVMembership;
import csvhandler.CSVTraining;
import membership.Membership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ResultList {

    Scanner input = new Scanner(System.in);

    // Trainingresults bliver opdateret hver gang vi kalder på .addresult
    // vi ønsker at få et array  der kun indeholder entries fra vores csv.
    // derfor erstatter vi værdien af trainingresults med en metode her hedder getResults;

    public void addTrainingResult() {
        List<TrainingResult> tempResult = new ArrayList<>();
        //Henter medlemmer midlertidligt til ID brug
        List<Membership> midlertidlig = new ArrayList<>();
        CSVMembership reader = new CSVMembership();
        reader.readCSV("src/CSVFiles/MembersList.CSV", midlertidlig);
        //Der indtastes ID-nummer og det sammenlignes med ID fra medlemsliste.
        // Derefter oprettes resultat-objekt med indtastede data.

        //List til lagring af nyt træningsresultat

        System.out.print("ID: ");
        int ID = input.nextInt();
        input.nextLine();

        Membership foundMember = null;
        for (Membership m : midlertidlig) { // Get the list of members from MembersList
            if (m.getID() == ID) {
                foundMember = m;
                break;
            }
        }

        if (foundMember == null) {
            System.out.println("Medlem ikke fundet.");
            return;
        }

        System.out.println("Navn: " + foundMember.getName());

//        System.out.print("Gruppe: ");
//        String group = input.nextLine();

        System.out.println("Disciplin: ");
        System.out.println("1. Crawl");
        System.out.println("2. Rygcrawl");
        System.out.println("3. Brystsvømning");
        System.out.println("4. Butterfly");

        String discipline = "";
        String choice = input.nextLine();

        switch (choice) {
            case "1" -> discipline = "Crawl";
            case "2" -> discipline = "Rygcrawl";
            case "3" -> discipline = "Brystsvømning";
            case "4" -> discipline = "Butterfly";
            default -> {
                System.out.println("Ugyldigt valg");
            }
        }

        System.out.print("Svømmetid: ");
        int time = input.nextInt();
        input.nextLine();

        System.out.print("Dato: ");
        String date = input.nextLine();

        // Opretter nyt result
        TrainingResult newResult = new TrainingResult(foundMember.getID(), foundMember.getName(), foundMember.group(), discipline, time, date);

        // Add the result to the training results array
        tempResult.add(newResult);

        System.out.println(newResult);

        CSVTraining writer = new CSVTraining();
        writer.writeCSV("src/csvfiles/TrainingResults.CSV", tempResult);

    }

    public void addCompResult() {
        List<CompetitionResult> tempResult = new ArrayList<>();
        //Henter medlemmer midlertidligt til ID brug
        List<Membership> midlertidlig = new ArrayList<>();
        CSVMembership reader = new CSVMembership();
        reader.readCSV("src/CSVFiles/MembersList.CSV", midlertidlig);
        //Der indtastes ID-nummer og det sammenlignes med ID fra medlemsliste.
        // Derefter oprettes resultat-objekt med indtastede data.

        //List til lagring af nyt træningsresultat

        System.out.print("ID: ");
        int ID = input.nextInt();
        input.nextLine();

        Membership foundMember = null;
        for (Membership m : midlertidlig) { // Get the list of members from MembersList
            if (m.getID() == ID) {
                foundMember = m;
                break;
            }
        }

        if (foundMember == null) {
            System.out.println("Medlem ikke fundet.");
            return;
        }

        System.out.println("Navn: " + foundMember.getName());

//        System.out.print("Gruppe: ");
//        String group = input.nextLine();

        System.out.println("Disciplin: ");
        System.out.println("1. Crawl");
        System.out.println("2. Rygcrawl");
        System.out.println("3. Brystsvømning");
        System.out.println("4. Butterfly");

        String discipline = "";
        String choice = input.nextLine();

        switch (choice) {
            case "1" -> discipline = "Crawl";
            case "2" -> discipline = "Rygcrawl";
            case "3" -> discipline = "Brystsvømning";
            case "4" -> discipline = "Butterfly";
            default -> {
                System.out.println("Ugyldigt valg");
            }
        }

        System.out.print("Svømmetid: ");
        int time = input.nextInt();
        input.nextLine();

        System.out.print("Dato: ");
        String date = input.nextLine();

        System.out.print("Placering: ");
        int rank = input.nextInt();
        input.nextLine();

        System.out.print("Stævne: ");
        String competition = input.nextLine();

        // Opretter nyt result
        CompetitionResult newResult = new CompetitionResult(foundMember.getID(), foundMember.getName(), foundMember.group(), discipline, time, date, competition, rank);

        // Add the result to the training results array
        tempResult.add(newResult);

        System.out.println(newResult);

        CSVCompetition writer = new CSVCompetition();
        writer.writeCSV("src/csvfiles/CompetitionResults.CSV", tempResult);

    }

    public void showTrainingResults() {

        List<TrainingResult> training = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", training);
        for (TrainingResult t : training) {

            System.out.println(t);
        }
    }

    public void showCompetitionResults() {

        List<CompetitionResult> comp = new ArrayList<>();
        CSVCompetition reader = new CSVCompetition();
        reader.readCSV("src/CSVFiles/CompetitionResults.CSV", comp);
        for (CompetitionResult c : comp) {

            System.out.println(c);
        }
    }
//    public void showCompetitionResults() {
//
//       List<CompetitionResult> showCResult = new ArrayList<>();
//        CSVCompetition reader = new CSVCompetition();
//       reader.readCSV("src/CSVFiles/CompetitionResults.CSV", showCResult );
//        if (showCResult.isEmpty()) {
//            System.out.println("Der er ingen konkurrenceresultater at vise.");
//        }
//
//        System.out.println("----- Konkurrence Resultater -----");
//        for (CompetitionResult result : showCResult) {
//            System.out.println(result);
//        }
//    }

}

