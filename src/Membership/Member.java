package Membership;

public class Member {
    String name;
    int age;
    double fee;
    boolean active;

    public Member(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.fee = calculateFee(age);
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
