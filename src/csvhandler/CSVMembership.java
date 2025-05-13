package csvhandler;

import membership.Membership;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class CSVMembership implements CSVHandler {
        //Metode til at læse CSV fil og konventere det til ArrayListen
        //(Virker ikke med Interface, da List parameterren skal modtage Membership)
    @Override
        public <T> void readCSV (String filepath, List<T> fromArray) {
            try (Scanner reader = new Scanner(new File(filepath))) {
                reader.nextLine();

                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] field = line.split(",");

                    int ID = Integer.parseInt(field[0]);
                    String name = field[1];
                    int age = Integer.parseInt(field[2]);
                    boolean active = Boolean.parseBoolean(field[4]);
                    boolean debt = Boolean.parseBoolean(field[5]);
                    boolean competitive = Boolean.parseBoolean(field[6]);
                    //Tilføjer filens data til arraylisten
                    @SuppressWarnings("unchecked")
                    List<Membership> casted = (List<Membership>) fromArray;
                    casted.add(new Membership(ID, name, age, active, debt, competitive));
                }
            } catch (FileNotFoundException y) {
                System.out.println("Fil ikke fundet");
            }
        }
        @Override
        public <T extends CSVWriteable> void writeCSV(String filepath, List<T> data) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
                for (T s : data) {
                    writer.println(s.toCSV());
                }
            } catch (IOException b) {
                System.out.println("Fil ikke fundet");
            }
        }
}
