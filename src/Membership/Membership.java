package Membership;


import java.time.LocalDate;

public class Membership extends Member {
    LocalDate payDate;
    String category;
    boolean debt;
    boolean competitive;

    public Membership(String name, int age, String category, boolean active, boolean debt, boolean competitive) {
        super(name, age, active);
        this.category = category;
        this.debt = debt;
        this.competitive = competitive;
    }

    public void showStatus() {
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public String category() {
        return category;
    }

    public boolean hasDebt() {
        return debt;
    }

    public boolean isCompetitive() {
        return competitive;
    }

    @Override
    public String toString() {
        return "Medlemsskab:" +

                "\n Navn: " + name +
                "\n Alder: " + age +
                "\n Kontingent: " + fee +
                "\n Aktiv: " + active +
                "\n Kategori: " + category +
                "\n Restance: " + debt +
                "\n Konkurrencesvømmer: " + competitive;
    }
    //Bruges til at skrive member data til CSV fil
    public String toCSV() {
        return name + "," + age + "," + category + "," + active + "," + debt + "," + competitive;
    }
}
