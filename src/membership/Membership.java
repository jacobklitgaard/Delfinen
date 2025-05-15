package membership;

import csvhandler.CSVWriteable;

public class Membership implements CSVWriteable {
    int ID;
    String name;
    int age;
    double fee;
    boolean active;
    String ageCategory;
    boolean debt;
    boolean competitive;

    public Membership(int ID, String name, int age, boolean active, boolean debt, boolean competitive) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.active = active;
        this.debt = debt;
        this.competitive = competitive;
        this.ageCategory = calculateCategory(age);
        this.fee = calculateFee(age);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean hasDebt() {
        return debt;
    }

    // Regner ud hvilken gruppe medlemmet er i
    public String calculateCategory(int age) {
        if (age < 18) {
            ageCategory = "Ung";
        }
        else if (age < 60) {
            ageCategory = "Voksen";
        }
        else {
            ageCategory = "Senior";
        }
        return ageCategory;
    }

    // Regner ud hvad medlemmet skal betale af kontigent
    public double calculateFee(int age){

        if(!active){
            return 500;
        }

        if(age < 18) {
            return 1000;
        }
        else if(age < 60){
            return 1600;
        }
        else {
          return 1200;
        }
    }

    public String group(){
        if(age < 18){
            return "Junior";
        }
        else {
            return "Senior";
        }
    }

    @Override
    public String toString() {
        return String.format(
                "_____________________" +
                "\n%-20s: %d" +
                        "\n%-20s: %s" +
                        "\n%-20s: %d år" +
                        "\n%-20s: %.2f kr." +
                        "\n%-20s: %s" +
                        "\n%-20s: %s" +
                        "\n%-20s: %s" +
                        "\n%-20s: %s",
                "ID", ID,
                "Navn", name,
                "Alder", age,
                "Kontingent", fee,
                "Aktiv", active ? "Ja" : "Nej",
                "Kategori", ageCategory,
                "Restance", debt ? "Ja" : "Nej",
                "Konkurrencesvømmer", competitive ? "Ja" : "Nej"
        );
    }

    //Bruges til at skrive member data til CSV fil
    @Override
    public String toCSV() {
        return ID + "," + name + "," + age + "," + ageCategory + "," + active + "," + debt + "," + competitive;
    }

    //// Returnerer kontingent beregnet ud fra medlemmets alder og status
    public double expectedFee() {
        return calculateFee(age);
    }
}
