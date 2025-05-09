package result;
import membership.Membership;

public class TrainingResult extends Result {      //til oprettelse af træningsresultater

    public TrainingResult(int ID, int time, String discipline, String group, String date) {
        super(ID, time, discipline, group, date);

    }

    public String resultToCSV() {
        return ID + "," + time + "," + discipline + "," + group + "," + date;
    }

}

