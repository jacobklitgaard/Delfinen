package Membership;
//Medlems attributter
public class Member {
    String name;
    int age;
    double fee;
    boolean active;
    String ageCategory;

    public Member(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.fee = calculateFee(age);
        this.ageCategory = calculateCategory(age);
    }

    //Getter og setter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getFee() {
        return fee;
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
}
