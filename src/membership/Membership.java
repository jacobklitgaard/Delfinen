package membership;

import java.time.LocalDate;
import java.util.List;

public class Membership {
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
        this.fee = calculateFee(age);
        this.ageCategory = calculateCategory(age);
    }

    public int getID() {
        return ID;
    }

    public static int getID(List<Membership> array) {

        int counter = 0;

        for(Membership m : array){
            counter++;
        }
        return 0 ;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public boolean isDebt() {
        return debt;
    }

    public boolean hasDebt() {
        return debt;
    }

    public boolean isCompetitive() {
        return competitive;
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
        if(age < 18) {
            fee = 1000;
        }
        else if(age < 60){
            fee = 1600;
        }
        else {
            fee = 1200;
        }
        if(!active){
            fee = 500;
        }
        return fee;
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
    public String memberToCSV() {
        return ID + "," + name + "," + age + "," + ageCategory + "," + active + "," + debt + "," + competitive;
    }


}
