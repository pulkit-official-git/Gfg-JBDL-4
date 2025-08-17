package Interface;

public interface Animal {

    default void dancing(){
        System.out.println("dancing");
    }
    
    public void eat();
    public void sleep();
    public void walk();
}
