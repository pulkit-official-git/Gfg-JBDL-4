package eximcombo;

public class Animal {

    String name;
    String color;
    int age;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void eat() {
        System.out.println("eating");
    }

    public void sleep(){
        System.out.println("sleeping");
    }
}
