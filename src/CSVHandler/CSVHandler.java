package CSVHandler;

import java.util.List;

public interface CSVHandler {
    //Læser CSV filen (fx. til at vise top 5 svømmere)
    void readCSV(String filepath);
    //Skriver til CSV filen (tilføjer ny data, som et medlem, om medlemmet er aktiv osv.)
    //List<?> betyder at metoden kan tage imod alle former for data.
    void writeCSV(String filepath, List<?> data);
}
