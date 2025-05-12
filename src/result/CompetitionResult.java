package result;

public class CompetitionResult extends Result{        //til oprettelse af konkurrenceresultater
    private String competition;
    private int rank;

    public CompetitionResult(int ID, String name, int time, String discipline, String group, String date, String competition, int rank) {
        super(ID, name, group, discipline, time, date);
        this.competition = competition;
        this.rank = rank;
    }

    public String getCompetition() {
        return competition;
    }

    public int getRank() {
        return rank;
    }

}
