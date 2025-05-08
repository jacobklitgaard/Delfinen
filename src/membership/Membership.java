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
    LocalDate payDate;
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

    public LocalDate getPayDate() {
        return payDate;
    }

    public boolean hasDebt() {
        return debt;
    }

    public boolean isCompetitive() {
        return competitive;
    }

    public void debt(){
        if(debt) System.out.println("ja");
    }

    // Regner ud hvilken gruppe medlemmet er i
    public String calculateCategory(int age) {
        if (age < 18) {
            ageCategory = "Ung";
        }
        if (age >= 18) {
            ageCategory = "Voksen";
        }
        if (age >= 60) {
            ageCategory = "Senior";
        }
        return ageCategory;
    }
    // Regner ud hvad medlemmet skal betale af kontigent
    public double calculateFee(int age){
        if(age < 18) {
            fee = 1000;
        }
        if(age >= 18){
            fee = 1600;
        }
        if(age >= 60){
            fee = 1200;
        }
        if(!active){
            fee = 500;
        }
        return fee;
    }

    @Override
    public String toString() {
        return "Medlemsskab:" +

                "\n ID: " + ID +
                "\n Navn: " + name +
                "\n Alder: " + age +
                "\n Kontingent: " + fee +
                "\n Aktiv: " + active +
                "\n Kategori: " + ageCategory +
                "\n Restance: " + debt +
                "\n Konkurrencesvømmer: " + competitive;
    }
    //Bruges til at skrive member data til CSV fil
    public String toCSV() {
        return ID + "," + name + "," + age + "," + ageCategory + "," + active + "," + debt + "," + competitive;
    }
}
