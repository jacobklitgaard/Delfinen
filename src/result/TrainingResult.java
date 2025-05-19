package result;

import csvhandler.CSVWriteable;

public class TrainingResult extends Result implements Comparable<TrainingResult>, CSVWriteable {      //til oprettelse af træningsresultater

    public TrainingResult(int ID, String name, String group, String discipline, int time, String date) {
        super(ID, name, group, discipline, time, date);

    }

    @Override
    public String toCSV() {
        return ID + "," + name + "," + group + "," + discipline + "," + time + "," + date;
    }

// ID, navn, gruppe, disciplin, svømmetid, dato

   @Override
    public String toString() {
       final String RESET = "\u001B[0m";
       final String CYAN = "\u001B[36m";
       final String FED = "\u001B[1m";

       return String.format(
               FED + "---------------------------------\n" + RESET +
                CYAN + "  ID         : %d\n" + RESET +
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

