package result;

import csvhandler.CSVWriteable;

public class CompetitionResult extends Result implements CSVWriteable {        //til oprettelse af konkurrenceresultater
    private String competition;
    private int rank;

    public CompetitionResult(int ID, String name, String group, String discipline, int time, String date, String competition, int rank) {
        super(ID, name, group, discipline, time, date);
        this.competition = competition;
        this.rank = rank;
    }
    @Override
    public String toCSV() {
        return ID + "," + name + "," + group + "," + discipline + "," + time + "," + date + "," + competition + "," + rank;
    }


    public String getCompetition() {
        return competition;
    }

    public int getRank() {
        return rank;
    }
    @Override
    public String toString() {
        return String.format(
                "---------------------------------\n" +
                        "  ID         : %d\n" +
                        "  Navn       : %s\n" +
                        "  Gruppe     : %s\n" +
                        "  Disciplin  : %s\n" +
                        "  Svømmetid  : %d sekunder\n" +
                        "  Dato       : %s\n" +
                        "  Stævne     : %s\n" +
                        "  Pladsering : %d",
                ID, name, group, discipline, time, date, competition, rank
        );
    }
}
