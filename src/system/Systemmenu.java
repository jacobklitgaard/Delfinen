package system;

import membership.MembersList;
import result.ResultList;
import result.TrainingResult;

import java.util.Scanner;

public class Systemmenu {
    Scanner input = new Scanner(System.in);
    ResultList resultlist = new ResultList();

    public void Cashier() {

    }

    public void Chairman() {

        MembersList opretMedlem = new MembersList();
        //UI til Formand
        boolean running = true;
        while (running) {
            System.out.println("\nHåndtere medlemmer:\n" +
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
            System.out.println("\nResultater:\n" +
                    "1: Registrer resultat\n" +
                    "2: Træning\n" +
                    "3: Konkurrence\n" +
                    "4: Gå tilbage");

            String choice = input.nextLine();
            switch (choice) {
                case "1" -> register(input);
                case "2" -> training(input);
                case "3" -> resultlist.showCompetitionResults();
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
                case "1" -> resultlist.showTrainingResults();
                case "2" -> topFiveJunior(input);
                case "3" -> topFiveSenior(input);
                case "4" -> inTrainingMenu = false;
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
                case "1" -> resultlist.getButterflyTopFiveJunior();
                case "2" -> resultlist.getCrawlTopFiveJunior();
                case "3" -> resultlist.getRygcrawlTopFiveJunior();
                case "4" -> resultlist.getBrystTopFiveJunior();
                case "5" -> inJuniorMenu = false;
                default -> System.out.println("Ugyldigt valg");
            }
        }
    }
}