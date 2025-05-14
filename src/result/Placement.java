package result;

import csvhandler.CSVTraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Placement {
    public static final String RESET = "\u001B[0m";
    public static final String FED = "\u001B[1m";
    public static final String RØD = "\u001B[31m";

    public void getButterflyTopFiveJunior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> butterflyJuniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("junior") && t.getDiscipline().equalsIgnoreCase("butterfly")) {
                butterflyJuniorResults.add(t);
            }
        }
        Collections.sort(butterflyJuniorResults);

        System.out.println(FED + RØD + "Top 5 Butterfly:" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(butterflyJuniorResults.get(i));
        }
    }

    public void getCrawlTopFiveJunior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> crawlJuniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("junior") && t.getDiscipline().equalsIgnoreCase("crawl")) {
                crawlJuniorResults.add(t);
            }
        }
        Collections.sort(crawlJuniorResults);

        System.out.println(FED + RØD +"Top 5 Crawl:" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(crawlJuniorResults.get(i));
        }
    }

    public void getRygcrawlTopFiveJunior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> rygcrawlJuniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("junior") && t.getDiscipline().equalsIgnoreCase("rygcrawl")) {
                rygcrawlJuniorResults.add(t);
            }
        }
        Collections.sort(rygcrawlJuniorResults);

        System.out.println(FED + RØD + "Top 5 Rygcrawl:" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(rygcrawlJuniorResults.get(i));
        }
    }

    public void getBrystTopFiveJunior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> brystJuniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("junior") && t.getDiscipline().equalsIgnoreCase("brystvømning")) {
                brystJuniorResults.add(t);
            }
        }
        Collections.sort(brystJuniorResults);

        System.out.println(FED + RØD + "Top 5 Crawl:" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(brystJuniorResults.get(i));
        }
    }

    public void getButterflyTopFiveSenior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> butterflySeniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("senior") && t.getDiscipline().equalsIgnoreCase("butterfly")) {
                butterflySeniorResults.add(t);
            }
        }
        Collections.sort(butterflySeniorResults);

        System.out.println(FED + RØD + "Top 5 Butterfly:" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(butterflySeniorResults.get(i));
        }
    }

    public void getCrawlTopFiveSenior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> crawlSeniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("senior") && t.getDiscipline().equalsIgnoreCase("crawl")) {
                crawlSeniorResults.add(t);
            }
        }
        Collections.sort(crawlSeniorResults);

        System.out.println(FED + RØD + "Top 5 Crawl:" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(crawlSeniorResults.get(i));
        }
    }

    public void getRygcrawlTopFiveSenior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> rygcrawlSeniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("senior") && t.getDiscipline().equalsIgnoreCase("crawl")) {
                rygcrawlSeniorResults.add(t);
            }
        }
        Collections.sort(rygcrawlSeniorResults);

        System.out.println(FED + RØD + "Top 5 Rygcrawl:" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(rygcrawlSeniorResults.get(i));
        }
    }


    public void getBrystTopFiveSenior() {

        List<TrainingResult> showTResult = new ArrayList<>();
        CSVTraining reader = new CSVTraining();
        reader.readCSV("src/CSVFiles/TrainingResults.CSV", showTResult);

        List<TrainingResult> brystSeniorResults = new ArrayList<>();
        for (TrainingResult t : showTResult) {
            if (t.getGroup().equalsIgnoreCase("senior") && t.getDiscipline().equalsIgnoreCase("crawl")) {
                brystSeniorResults.add(t);
            }
        }

        Collections.sort(brystSeniorResults);

        System.out.println(FED + RØD + "Top 5 Crawl:" + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.println(brystSeniorResults.get(i));
        }
    }
}
