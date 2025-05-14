package system;

import java.util.Scanner;

public class UI {
    // ANSI-farvekoder
    public static final String RESET = "\u001B[0m";
    public static final String RØD = "\u001B[31m";
    public static final String GRØN = "\u001B[32m";
    public static final String GUL = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    private Scanner input = new Scanner(System.in);
    Systemmenu sm = new Systemmenu();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println(GUL + "System Menu" + RESET);
            System.out.println(GRØN + "1: Håndtere medlemmer" + RESET);
            System.out.println(CYAN + "2: Svømmeresultater" + RESET);
            System.out.println(GRØN + "3: Økonomi" + RESET);
            System.out.println(RØD + "4: Luk system." + RESET);
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Skriv pinkode... (4 cifre)");
                    int password = input.nextInt();
                    input.nextLine();
                    if (password == 4358) {
                        sm.Chairman();
                    } else {
                        System.out.println("Forkert kodeord");
                    }
                }
                case "2" -> {
                    System.out.println("Skriv pinkode... (4 cifre)");
                    int password = input.nextInt();
                    input.nextLine();
                    if (password == 1234) {
                        sm.Trainer();
                    } else {
                        System.out.println("Forkert kodeord");
                    }
                }
                case "3" -> {
                    System.out.println("Skriv pinkode... (4 cifre)");
                    int password = input.nextInt();
                    input.nextLine();
                    if (password == 6127) {
                        sm.Cashier();
                    } else {
                        System.out.println("Forkert kodeord");
                    }
                }
                case "4" -> {
                    //Lukker programmet
                    System.out.println("Lukker systemet...");
                    running = false;
                    input.close();
                }
            }
        }
    }

 /*   public int password (int password, String type) {
        if (type.equalsIgnoreCase("chairman")) {
            password = 8763;
            return
        }
    }*/
}
