package system;

import membership.MembersList;
import result.ResultList;
import result.TrainingResult;

import java.util.Scanner;

public class Systemmenu {
    Scanner input = new Scanner(System.in);
    ResultList resultlist = new ResultList();

    public void Chairman() {

        MembersList createMembers = new MembersList();
        //UI til Formand
        boolean running = true;
        while (running) {
            System.out.println("\nHåndtere medlemmer:\n" +
                    "1: Opret medlem\n" +
                    "2: Vis medlemmer\n" +
                    "3: Gå tilbage");
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> createMembers.createMember();
                case "2" -> createMembers.showMembers();
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
                case "1" -> resultlist.addTrainingResult();
                case "2" -> resultlist.addCompResult();
                case "3" -> inRegMenu = false;
                default -> System.out.println("Ugyldigt valg");
            }
        }
    }

    public void training(Scanner input) {
        boolean inTrainingMenu = true;
        while (inTrainingMenu) {
            System.out.println("1. Alle");
            System.out.println("2. Top 5 Junior");
            System.out.println("3. Top 5 Senior");
            System.out.println("4. Gå tilbage");
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

    public void topFiveJunior(Scanner input) {
        boolean inJuniorMenu = true;
        while (inJuniorMenu) {
            System.out.println("1. Butterfly");
            System.out.println("2. Crawl");
            System.out.println("3. Rygcrawl");
            System.out.println("4. Brystsvømning");
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

    public void topFiveSenior(Scanner input) {
        boolean inSeniorMenu = true;
        while (inSeniorMenu) {
            System.out.println("1. Butterfly");
            System.out.println("2. Crawl");
            System.out.println("3. Rygcrawl");
            System.out.println("4. Brystsvømning");
            System.out.println("5. Gå tilbage");
            String choice = input.nextLine();

            switch (choice) {
                case "1" -> resultlist.getButterflyTopFiveSenior();
                case "2" -> resultlist.getCrawlTopFiveSenior();
                case "3" -> resultlist.getRygcrawlTopFiveSenior();
                case "4" -> resultlist.getBrystTopFiveSenior();
                case "5" -> inSeniorMenu = false;
                default -> System.out.println("Ugyldigt valg");
            }
        }
    }

    public void Cashier() { //UI til Kassere
        MembersList membersList = new MembersList();
        boolean running = true;

        while (running){
            System.out.println("\nØkonomi:\n" +
                    "1: Vis samlet kontingentbetaling\n" +
                    "2: Vis medlemmer i retance\n" +
                    "3: Gå tilbage");
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> membersList.showExpectedPayments();
                case "2" -> membersList.showMembersInDebt();
                case "3" -> running = false;
                default -> System.out.println("Vælg 1, 2 eller 3");
            }
        }
    }
}
