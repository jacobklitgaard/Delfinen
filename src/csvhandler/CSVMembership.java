package csvhandler;

import membership.Membership;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class CSVMembership implements CSVHandler {
    //Metode til at læse CSV fil og skrive det til Arraylisten.
    @Override
    public <T> void readCSV (String filepath, List<T> fromArray) {
        //Bruger scanner til at læste filen
        try (Scanner reader = new Scanner(new File(filepath))) {
            //Læser næste (i dette tilfælde den første) linje i filen (Header linjen):
            reader.nextLine();
                //While loop der køre imens Scanneren kan læse næste linje i filen.
                //Når alle linjer er læst i filen, vil while loopet stoppe:
                while (reader.hasNextLine()) {
                    //Gemmer linjen som scanneren læser i en String "line".
                    //Herefter bruges split metoden på "line", til at inddele vores linje af data fra filen
                    //  i en (old school) array "field". Dette gøres med "," som også separere data'en i CSV filen.
                    //Hver gang "," fremgår i filen, og scanneren læser det, vil den læse næste fælt i linjen
                    String line = reader.nextLine();
                    String[] field = line.split(",");

                    //Her vil læseren gå igennem hver separeret fælt, og inddele det på array "field".
                    //Scanneren læser hvert fælt, og vi tildeler feltet til en variable der bliver gemt
                    //  i array "field" indexer.
                    int ID = Integer.parseInt(field[0]);
                    String name = field[1];
                    int age = Integer.parseInt(field[2]);
                    boolean active = Boolean.parseBoolean(field[4]);
                    boolean debt = Boolean.parseBoolean(field[5]);
                    boolean competitive = Boolean.parseBoolean(field[6]);
                    //Når scanneren har læst en linje er dataen gemt i (i dette tilfælde 6) indexer i "field".

                    //Caster arraylist med membership parameter, så den kan bruges istedet for T
                    //(Bliver man nød til da vi skal tilføje objektet til arraylisten)...
                    List<Membership> casted = (List<Membership>) fromArray;

                    //Variablerne som er gemt i "field"s indexer, bliver tilføjet til et index i Arraylisten...
                    casted.add(new Membership(ID, name, age, active, debt, competitive));

                    //while loopet fortsætter med at tilføje "field" array, med 6 indexer af data, til listen
                    //  indtil den ikke kan læse flere linjer i filen, hvor loopet stopper.
                }
        } catch (FileNotFoundException y) {
            System.out.println("Fil ikke fundet");
        }
    }
    //Metode til at skrive data fra en Arraylist til CSV fil.
    @Override
    //"T" er en generic, der tager imod alt data. (En slags placeholder til parameteren i List).
    //T extender CSVWritable, da der er en metode til at toCSV i interfacet. Dette giver adgang til metoden
    //  selvom T ikke har en toCSV metode. (fx ligesom Membership klassen)
    public <T extends CSVWriteable> void writeCSV(String filepath, List<T> data) {
        //Åbner printwriter som skriver til filen, med append true, for at skrive videre på næste linje
        try (PrintWriter writer = new PrintWriter(new FileWriter(filepath, true))) {
            //Læser arraylisten
            for (T s : data) {
                //Skriver data fra Arraylisten ind i csv filen, med toCSV metoden.
                //Dette kan lade sig gøre, da vi kun opretter et objekt af gangen. Derved skal vi kun
                //  bruge en linje data som skal skrives ind i filen. (sikkert en smartere/sejere måde at gøre det på men det her er nemmest).
                //Derfor bruges der en ny arrayliste når writeren skal køre, da arraylisten kun skal opbevare data i et index.
                writer.println(s.toCSV());
            }
        } catch (IOException b) {
            System.out.println("Fil ikke fundet");
        }
    }
}
