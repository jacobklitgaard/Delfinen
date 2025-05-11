package result;

import membership.MembersList;
import membership.Membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultList {
    private final List<CompetitionResult> competitionResults = new ArrayList<>();
    private final List<TrainingResult> trainingResults = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);
    private final MembersList membersList = new MembersList();

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

        System.out.print("Svømmetid: ");
        int time = input.nextInt();
        input.nextLine();

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

}