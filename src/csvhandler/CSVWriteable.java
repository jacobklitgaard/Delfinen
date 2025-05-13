package csvhandler;

public interface CSVWriteable {
    //Metode til at formattere data fra et objekt (Membership, CompetitionResults og TrainingResults)
    //  til en CSV fil (Med writeCSV metoden fra CSVHandler)
    String toCSV();
}
