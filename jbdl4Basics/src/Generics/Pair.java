package Generics;

public class Pair <A,B> {

    A first;
    B second;

    public static <B> void doesSomething(B b){
        System.out.println(b);
    }

    public void setFirst(A val){
        first = val;
    }

    public B getSecond(){
        return second;
    }

    public <B> void doSomething(B b){
        System.out.println(second);
    }

    public <Z,Y>void doingSomething(Z z,Y y){
        System.out.println(z);
    }


}
