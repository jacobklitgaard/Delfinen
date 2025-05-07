package Results;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultLists {
    private final List<CompetitionResults> competitionResults = new ArrayList<>();
    private final List<TrainingResults> trainingResults = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);
    private String trainingString;
    private LocalDateTime trainingSesh;

    public void addTrainingResult() {
        System.out.print("Navn: ");
        String name = input.nextLine();

        System.out.print("Dato: ");
        trainingString = input.nextLine();
        trainingSesh = LocalDateTime.parse(trainingString);
        input.nextLine();


    }

    public void addCompResult() {

    }
}