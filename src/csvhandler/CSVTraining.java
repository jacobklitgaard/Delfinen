package csvhandler;

import result.TrainingResult;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class CSVTraining {

    //metode kopieret fra CSVmembership som skal skrive resultater til array
    public void readCSV (String filepath, List<TrainingResult> fromArray) {

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
                fromArray.add(new TrainingResult(memberID, name, group, discipline, time, date));
            }
        } catch (FileNotFoundException y) {
            System.out.println("Fil ikke fundet");
        }
    }


    public void writeCSV(String filepath, List<TrainingResult> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
for (TrainingResult t : data) {
                writer.println(t.resultToCSV());
            }
        } catch (IOException b) {
            System.out.println("Fil ikke fundet");
        }
    }

}
