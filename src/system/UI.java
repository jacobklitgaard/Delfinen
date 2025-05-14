package system;

import java.util.Scanner;

public class UI {
    // ANSI-farvekoder
    public static final String RESET = "\u001B[0m";
    public static final String LYSGRØN = "\u001B[92m";
    public static final String CYAN = "\u001B[36m";
    public static final String LYSRØD ="\u001B[91m";
    public static final String LYSLILLA = "\u001B[95m";
    public static final String LYSGUL = "\u001B[93m";

    public static final String UNDERSTREGET = "\u001B[4m";


    private Scanner input = new Scanner(System.in);
    Systemmenu sm = new Systemmenu();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println(UNDERSTREGET + CYAN + "🐬 System Menu 🐬" + RESET);
            System.out.println(LYSGRØN + "1: Håndter medlemmer" + RESET);
            System.out.println(LYSGUL + "2: Svømmeresultater" + RESET);
            System.out.println(LYSLILLA + "3: Økonomi" + RESET);
            System.out.println(LYSRØD + "4: Luk system ‼️" + RESET);
            String choice = input.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("🔐Skriv pinkode... (4358)");
                    int password = input.nextInt();
                    input.nextLine();
                    if (password == 4358) {
                        sm.Chairman();
                    } else {
                        System.out.println("❌ Forkert kodeord ❌");
                    }
                }
                case "2" -> {
                    System.out.println("🔐Skriv pinkode... (1234)");
                    int password = input.nextInt();
                    input.nextLine();
                    if (password == 1234) {
                        sm.Trainer();
                    } else {
                        System.out.println("❌ Forkert kodeord ❌");
                    }
                }
                case "3" -> {
                    System.out.println("🔐Skriv pinkode... (6127)");
                    int password = input.nextInt();
                    input.nextLine();
                    if (password == 6127) {
                        sm.Cashier();
                    } else {
                        System.out.println("❌ Forkert kodeord ❌");
                    }
                }
                case "4" -> {
                    //Lukker programmet
                    System.out.println("Lukker systemet... ⏳");
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
