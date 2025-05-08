package system;

import membership.MembersList;
import result.ResultLists;
import result.TrainingResult;

import java.util.Scanner;

public class Systemmenu {
    Scanner input = new Scanner(System.in);
    ResultLists rl = new ResultLists();

    public void Cashier() {

    }

    public void Chairman() {

        MembersList opretMedlem = new MembersList();
        //UI til Formand
        boolean running = true;
        while (running) {
            System.out.println("Håndtere medlemmer....\n" +
                    "1: Opret medlem\n" +
                    "2: Vis medlemmer\n" +
                    "3: Gå tilbage");
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> opretMedlem.opretMedlem();
                case "2" -> opretMedlem.visMedlemmer();
                case "3" -> running = false;
            }
        }
    }

    public void Trainer() {
        //UI til træner
        Boolean running = true;
        while (running) {
            System.out.println("Resultater....\n" +
                    "1: Registrer resultat\n" +
                    "2: Træningsresultater\n" +
                    "3: Konkurrenceresultater\n" +
                    "4: Gå tilbage");

            String choice = input.nextLine();
            switch (choice) {
                case "1" -> register(input);
                //case "2" -> trainingresults();
                //case "3" -> compResults();
                case "4" -> running = false;
                default -> System.out.println("Ugyldigt valg");
            }
        }
    }
    public void register(Scanner input) {
        boolean inRegMenu = true;
        while (inRegMenu) {
            System.out.println("1. Træningsresultat");
            System.out.println("2. Konkurrenceresultat");
            System.out.println("3. Gå tilbage");
            String choice = input.nextLine();

            switch (choice) {
                case "1" -> rl.addTrainingResult();
                case "2" -> regComp(input);
                case "3" -> inRegMenu = false;
                default -> System.out.println("Ugyldigt valg");
            }
        }
    }
    public void regTraining(Scanner input) {
        boolean inTrainingMenu = true;
        while (inTrainingMenu) {
            System.out.println("1. Crawl");
            System.out.println("2. Rygcrawl");
            System.out.println("3. Brystsvømning");
            System.out.println("4. Butterfly");
            System.out.println("5. Gå tilbage");
            String choice = input.nextLine();

            switch (choice) {
//                case "1" -> addTrainingResult();
//                case "2" -> addTrainingResult();
//                case "3" -> addTrainingResult();
//                case "4" -> addTrainingResult();
                case "5" -> inTrainingMenu = false;
                default -> System.out.println("Ugyldigt valg");
            }
        }
    }
    public void regComp(Scanner input) {
        boolean inCompMenu = true;
        while (inCompMenu) {
            System.out.println("1. Crawl");
            System.out.println("2. Rygcrawl");
            System.out.println("3. Brystsvømning");
            System.out.println("4. Butterfly");
            System.out.println("5. Gå tilbage");
            String choice = input.nextLine();

            switch (choice) {
//                case "1" -> addCompResult();
//                case "2" -> addCompResult();
//                case "3" -> addCompResult();
//                case "4" -> addCompResult();
                case "5" -> inCompMenu = false;
                default -> System.out.println("Ugyldigt valg");
            }
        }
    }
}