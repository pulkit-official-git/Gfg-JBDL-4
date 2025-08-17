package eximcombo;

public class Client {
    public static void main(String[] args) {
        Duck a = new Duck("d1",5,"white");
        a.fly();
        a.eat();
        System.out.println(a.name);
        System.out.println(a.color);
    }
}
