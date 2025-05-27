package system;

import java.util.Scanner;

public class UI {
    // ANSI-farvekoder
    public static final String RESET = "\u001B[0m";
    public static final String RØD = "\u001B[31m";
    public static final String GRØN = "\u001B[32m";
    public static final String GUL = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String FED = "\u001B[1m";
    public static final String BLÅ = "\u001B[94m";


    private final Scanner input = new Scanner(System.in);
    Systemmenu sm = new Systemmenu();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\u001B[1m" + BLÅ + FED + "System Menu" + RESET);
            System.out.println(GRØN + "1: Håndtere medlemmer" + RESET);
            System.out.println(CYAN + "2: Svømmeresultater" + RESET);
            System.out.println(GUL + "3: Økonomi" + RESET);
            System.out.println(RØD + "4: Luk system" + RESET);
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> sm.Chairman();
                case "2" -> sm.Trainer();
                case "3" -> sm.Cashier();
                case "4" -> {
                    //Lukker programmet
                    System.out.println(FED + RØD + "Lukker systemet..." + RESET);
                    running = false;
                    input.close();
                }
                default -> System.out.println(RØD + FED + "Ugyldig input, prøv igen" + RESET);
            }
        }
    }
}

