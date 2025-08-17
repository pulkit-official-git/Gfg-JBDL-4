package Interface;

public class Dog implements Animal{
//    @Override
    public void eat() {
        System.out.println("eating");
    }

    @Override
    public void sleep() {
        System.out.println("sleeping");
    }

    @Override
    public void walk() {
        System.out.println("walking");
    }
}
