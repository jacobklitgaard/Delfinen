package result;
import membership.Membership;

public class TrainingResult extends Result implements Comparable<TrainingResult>  {      //til oprettelse af træningsresultater

    public TrainingResult(int ID, String name, String group, String discipline, int time, String date) {
        super(ID, name, group, discipline, time, date);

    }

    public String resultToCSV() {
        return ID + "," + name + "," + group + "," + discipline + "," + time + "," + date;
    }

// ID, navn, gruppe, disciplin, svømmetid, dato

   @Override
    public String toString() {
        return "TrainingResult{" +
                "ID=" + ID +
                ", Navn='" + name + '\'' +
                ", Gruppe = '" + group + '\'' +
                ", Disciplin ='" + discipline + '\'' +
                ", Svømmetid = " + time +
                ", Dato ='" + date + '\'' +
                '}';
    }

    @Override
    public int compareTo(TrainingResult o) {
        return Integer.compare(time, o.time);
    }
}

