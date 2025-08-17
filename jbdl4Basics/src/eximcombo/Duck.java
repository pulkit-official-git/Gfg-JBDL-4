package eximcombo;

public class Duck extends Animal implements Flyable,Swimmable{

    Duck(String name, int age, String color) {
        super(name, color, age);
    }

    @Override
    public void fly() {
        System.out.println("flying");
    }

    @Override
    public void swim() {
        System.out.println("swiming");
    }
}
