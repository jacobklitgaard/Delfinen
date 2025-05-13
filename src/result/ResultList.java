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

    public void getButterflyTopFiveJunior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> butterflyJuniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("junior") && t.getDiscipline().equalsIgnoreCase("butterfly")) {
                butterflyJuniorResults.add(t);
            }
        }
        Collections.sort(butterflyJuniorResults);

        System.out.println("Top 5 Butterfly:");
        for (int i = 0; i < 5; i++) {
            System.out.println(butterflyJuniorResults.get(i));
        }
    }

    public void getCrawlTopFiveJunior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> crawlJuniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("junior") && t.getDiscipline().equalsIgnoreCase("crawl")) {
                crawlJuniorResults.add(t);
            }
        }
        Collections.sort(crawlJuniorResults);

        System.out.println("Top 5 Crawl:");
        for (int i = 0; i < 5; i++) {
            System.out.println(crawlJuniorResults.get(i));
        }
    }

    public void getRygcrawlTopFiveJunior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> rygcrawlJuniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("junior") && t.getDiscipline().equalsIgnoreCase("rygcrawl")) {
                rygcrawlJuniorResults.add(t);
            }
        }
        Collections.sort(rygcrawlJuniorResults);

        System.out.println("Top 5 Rygcrawl:");
        for (int i = 0; i < 5; i++) {
            System.out.println(rygcrawlJuniorResults.get(i));
        }
    }

    public void getBrystTopFiveJunior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> brystJuniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("junior") && t.getDiscipline().equalsIgnoreCase("brystvømning")) {
                brystJuniorResults.add(t);
            }
        }
        Collections.sort(brystJuniorResults);

        System.out.println("Top 5 Crawl:");
        for (int i = 0; i < 5; i++) {
            System.out.println(brystJuniorResults.get(i));
        }
    }

    public void getButterflyTopFiveSenior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> butterflySeniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("senior") && t.getDiscipline().equalsIgnoreCase("butterfly")) {
                butterflySeniorResults.add(t);
            }
        }
        Collections.sort(butterflySeniorResults);

        System.out.println("Top 5 Butterfly:");
        for (int i = 0; i < 5; i++) {
            System.out.println(butterflySeniorResults.get(i));
        }
    }

    public void getCrawlTopFiveSenior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> crawlSeniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("senior") && t.getDiscipline().equalsIgnoreCase("crawl")) {
                crawlSeniorResults.add(t);
            }
        }
        Collections.sort(crawlSeniorResults);

        System.out.println("Top 5 Crawl:");
        for (int i = 0; i < 5; i++) {
            System.out.println(crawlSeniorResults.get(i));
        }
    }

    public void getRygcrawlTopFiveSenior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> rygcrawlSeniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("senior") && t.getDiscipline().equalsIgnoreCase("crawl")) {
                rygcrawlSeniorResults.add(t);
            }
        }
        Collections.sort(rygcrawlSeniorResults);

        System.out.println("Top 5 Rygcrawl:");
        for (int i = 0; i < 5; i++) {
            System.out.println(rygcrawlSeniorResults.get(i));
        }
    }


    public void getBrystTopFiveSenior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> brystSeniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("senior") && t.getDiscipline().equalsIgnoreCase("crawl")) {
                brystSeniorResults.add(t);
            }
        }
        Collections.sort(brystSeniorResults);

        System.out.println("Top 5 Crawl:");
        for (int i = 0; i < 5; i++) {
            System.out.println(brystSeniorResults.get(i));
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

