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
                int time = Integer.parseInt(field[1]);
                String discipline = (field[2]);
                String group = (field[3]);
                String date = (field[4]);
                //Tilføjer filens data til arraylisten
                fromArray.add(new TrainingResult(memberID, time, discipline, group, date));
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
