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
        return "Membership:" +
                "\n category = '" + category + '\'' +
                "\n debt = " + debt +
                "\n competitive = " + competitive +
                "\n name =' " + name + '\'' +
                "\n age = " + age +
                "\n fee = " + fee +
                "\n active = " + active;
    }
}
