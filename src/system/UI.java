package system;

import java.util.Scanner;

public class UI {
    private Scanner input = new Scanner(System.in);
    Systemmenu sm = new Systemmenu();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("System Menu\n" +
                    "1: Håndtere medlemmer\n" +
                    "2: Svømmeresultater\n" +
                    "3: Økonomi\n" +
                    "4: Luk system.");
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> sm.Chairman();
                case "2" -> sm.Trainer();
                case "3" -> sm.Cashier();
                case "4" -> {
                    //Lukker programmet
                    System.out.println("Lukker systemet...");
                    running = false;
                    input.close();
                }
            }
        }
    }
}
