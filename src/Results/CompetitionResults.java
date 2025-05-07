package Results;

public class CompetitionResults extends Results{
    private String competition;
    private int rank;

    public CompetitionResults(int time, String discipline, String group, String date, String competition, int rank) {
        super(time, discipline, group, date);
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
