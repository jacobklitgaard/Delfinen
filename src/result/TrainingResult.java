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
       return String.format(
               "---------------------------------\n" +
                       "  ID         : %d\n" +
                       "  Navn       : %s\n" +
                       "  Gruppe     : %s\n" +
                       "  Disciplin  : %s\n" +
                       "  Svømmetid  : %d sekunder\n" +
                       "  Dato       : %s",
               ID, name, group, discipline, time, date
       );
    }

    @Override
    public int compareTo(TrainingResult o) {
        return Integer.compare(time, o.time);
    }
}

