package chaining;

public class C extends B {
//    public C() {
//        System.out.println("Inside C constructor");
//    }
    public C(int a) {
        System.out.println("Inside C constructor" + " "+ a);
    }
    public C(int a, int b) {
        super("apple");
        System.out.println("Inside C constructor" + " "+ a + b);
    }
}
