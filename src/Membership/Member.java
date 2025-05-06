package Membership;

import java.util.Locale;

public class Member {
    String name;
    int age;
    double fee;
    boolean active;
    String agecategory;

    public Member(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.fee = calculateFee(age);
        this.agecategory = calculateCategory(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getFee() {
        return fee;
    }

    public String calculateCategory(int age) {
        if (age < 18) {
            agecategory = "ung";
        }
        if (age >= 18) {
            agecategory = "voksen";
        }
        if (age >= 60) {
            agecategory = "senior";
        }
        return agecategory;
    }

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
}
