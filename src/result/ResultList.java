package result;

import membership.MembersList;
import membership.Membership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ResultList {
    List<CompetitionResult> competitionResults = new ArrayList<>();


    Scanner input = new Scanner(System.in);

    // Trainingresults bliver opdateret hver gang vi kalder på .addresult
    // vi ønsker at få et array  der kun indeholder entries fra vores csv.
    // derfor erstatter vi værdien af trainingresults med en metode her hedder getResults;

    public void addTrainingResult() {

        //Der indtastes ID-nummer og det sammenlignes med ID fra medlemsliste.
        // Derefter oprettes resultat-objekt med indtastede data.
        System.out.print("ID: ");
        int ID = input.nextInt();

        Membership foundMember = null;
        for (Membership m : membersList.getMembersList()) { // Get the list of members from MembersList
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

        System.out.print("Disciplin: ");
        String discipline = input.nextLine();

        System.out.print("Gruppe: ");
        String group = input.nextLine();

        System.out.print("Dato: ");
        String date = input.nextLine();

        // Add the result to the training results list
        trainingResults.add(new TrainingResult(foundMember.getID(), time, discipline, group, date));
    }


    public void addCompResult() {
        System.out.print("ID: ");
        String name = input.nextLine();

        System.out.print("Dato: ");

        input.nextLine();

        System.out.println("Svømmetid: ");

    }

    public void showTrainingResults() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);
        for (TrainingResult t : showTResult) {

            System.out.println(t);
        }
    }

    public void getButterflyTopFive() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> butterflyResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getDiscipline().equalsIgnoreCase("butterfly")) {
                butterflyResults.add(t);
            }
        }
        Collections.sort(butterflyResults);

        System.out.println("Top 5 Butterfly:");
        for (int i = 0; i < 5; i++) {
            System.out.println(butterflyResults.get(i));
        }
    }

    public void getCrawlTopFive() {

    }
}
