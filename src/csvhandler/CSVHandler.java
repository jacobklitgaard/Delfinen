package csvhandler;

import membership.Membership;

import java.util.List;

public interface CSVHandler {
    //Læser CSV filen (fx. til at vise top 5 svømmere)
    <T> void readCSV(String filepath, List<T> fromArray);
    //Skriver til CSV filen (tilføjer ny data, som et medlem, om medlemmet er aktiv osv.)
    //List<?> betyder at metoden kan tage imod alle former for data.
    <T extends CSVWriteable> void writeCSV(String filepath, List<T> data);
}
