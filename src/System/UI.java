package System;

import java.util.Scanner;

public class UI {
    private Scanner input = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("System Menu\n" +
                    "1: \n" +
                    "2: \n" +
                    "3: \n" +
                    "4: Luk system.");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {
                    //Lukker programmet
                    System.out.println("Lukker systemet...");
                    running = false;
                }
            }
        }
    }
}
