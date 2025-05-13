package csvhandler;

import result.CompetitionResult;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class CSVCompetition implements CSVHandler {

    //Metode kopieret fra CSVMembership som skal skrive resultater til array
    //  (Se CSVMembership for kommentarer)
    @Override
    public <T> void readCSV (String filepath, List<T> fromArray) {

        try (Scanner reader = new Scanner(new File(filepath))) {
            reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] field = line.split(",");

                int ID = Integer.parseInt(field[0]);
                String name = (field[1]);
                String group = (field[2]);
                String discipline = (field[3]);
                int time = Integer.parseInt(field[4]);
                String date = (field[5]);
                String competition = (field[6]);
                int rank = Integer.parseInt (field [7]);

                List<CompetitionResult> casted = (List<CompetitionResult>) fromArray;
                casted.add(new result.CompetitionResult(ID, name, group, discipline, time, date, competition, rank));
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