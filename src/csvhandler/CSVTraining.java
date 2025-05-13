package csvhandler;

import result.TrainingResult;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class CSVTraining implements CSVHandler {

    //Metode kopieret fra CSVMembership som skal skrive resultater til array
    //  (Se CSVMembership for kommentarer)
    @Override
    public <T> void readCSV (String filepath, List<T> fromArray) {

        try (Scanner reader = new Scanner(new File(filepath))) {
            reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] field = line.split(",");

                int memberID = Integer.parseInt(field[0]);
                String name = (field[1]);
                String group = (field[2]);
                String discipline =(field[3]);
                int time = Integer.parseInt(field[4]);
                String date = (field[5]);
                //Tilføjer filens data til arraylisten
                List<TrainingResult> casted = (List<TrainingResult>) fromArray;
                casted.add(new TrainingResult(memberID, name, group, discipline, time, date));
            }
        } catch (FileNotFoundException y) {
            System.out.println("Fil ikke fundet");
        }
    }

    @Override
    public <T extends CSVWriteable> void writeCSV(String filepath, List<T> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
            for (T t : data) {
                writer.println(t.toCSV());
            }
        } catch (IOException b) {
            System.out.println("Fil ikke fundet");
        }
    }
}
