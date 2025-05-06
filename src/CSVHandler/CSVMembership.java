package CSVHandler;

import Membership.Membership;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class CSVMembership {
        //Metode til at læse CSV fil og konventere det til ArrayListen
        //(Virker ikke med Interface, da List parameterren skal modtage Membership)
        public void readCSV (String filepath, List<Membership> fromArray) {
            try (Scanner reader = new Scanner(new File(filepath))) {
                reader.nextLine();

                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] field = line.split(",");

                    String name = field[0];
                    int age = Integer.parseInt(field[1]);
                    String category = field[2];
                    boolean active = Boolean.parseBoolean(field[3]);
                    boolean debt = Boolean.parseBoolean(field[4]);
                    boolean competitive = Boolean.parseBoolean(field[5]);
                    //Tilføjer filens data til arraylisten
                    fromArray.add(new Membership(name, age, category, active, debt, competitive));
                }
            } catch (FileNotFoundException y) {
                System.out.println("Fil ikke fundet");
            }
        }


        public void writeCSV(String filepath, List<Membership> data) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
                for (Membership s : data) {
                    writer.println(s.toCSV());
                }
            } catch (IOException b) {
                System.out.println("Fil ikke fundet");
            }
        }
}
