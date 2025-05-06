package Membership;


import java.time.LocalDate;

public class Membership extends Member {
    LocalDate payDate;
    boolean debt;
    boolean competitive;

    public Membership(String name, int age, boolean active, boolean debt, boolean competitive) {
        super(name, age, active);
        this.debt = debt;
        this.competitive = competitive;
    }

    public void showStatus() {
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

    @Override
    public String toString() {
        return "Medlemsskab:" +

                "\n Navn: " + name +
                "\n Alder: " + age +
                "\n Kontingent: " + fee +
                "\n Aktiv: " + active +
                "\n Kategori: " + agecategory +
                "\n Restance: " + debt +
                "\n Konkurrencesvømmer: " + competitive;
    }
    //Bruges til at skrive member data til CSV fil
    public String toCSV() {
        return name + "," + age + "," + agecategory + "," + active + "," + debt + "," + competitive;
    }
}
