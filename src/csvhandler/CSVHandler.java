package csvhandler;

import java.util.List;

public interface CSVHandler {
    //Læser CSV filen og tilføjer det til en Arrayliste "fromArray" (fx. til at vise top 5 svømmere)
    <T> void readCSV(String filepath, List<T> fromArray);

    //Skriver data fra Arraylisten "data" og skriver det til CSV filen.
    //<T> er en placeholder for objektet i Arraylisten. (Tillader at bruge alle objekter i Arraylisten).
    //Extender CSVWritable for at bruge toCSV metoden. (Se CSVMembership)
    <T extends CSVWriteable> void writeCSV(String filepath, List<T> data);
}
