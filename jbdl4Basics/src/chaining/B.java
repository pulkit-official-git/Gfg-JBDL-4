package chaining;

public class B extends A {
    public B() {
        System.out.println("Inside B constructor");
    }

    public B(String a) {
        System.out.println("Inside B constructor" +" "+a);
    }
}
