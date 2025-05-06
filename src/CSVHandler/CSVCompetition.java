package CSVHandler;

import Membership.Membership;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class CSVCompetition implements CSVHandler {

    @Override
    public void readCSV(String filepath) {
        try {
            File fil = new File("src/CSVFiles/CompetitionResults");
            Scanner scanner = new Scanner(fil);
            while (scanner.hasNextLine()){
                String results = scanner.nextLine();
                System.out.println(results);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke fundet");
        }
    }

    @Override
    public void writeCSV(String filepath, List<?> data) {
        try {
            PrintWriter writer = new PrintWriter(new File("src/CSVFiles/CompetitionResults"));
            writer.println();
        } catch (FileNotFoundException b) {
            System.out.println("Fil ikke fundet");
        }
    }
}
