package Threads;

public class Client {

    public static void doSomething(){
        System.out.println(Thread.currentThread().getName()+"static");
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        doSomething();


        HelloWorld helloWorld = new HelloWorld();
        Thread t1 = new Thread(helloWorld,"T1");
        t1.start();

        for(int i = 0; i < 100; i++) {

            if(i==80){
                int x=1;
            }

            PrintNumberUsingThread printNumberUsingThread = new PrintNumberUsingThread(i);
            Thread t2 = new Thread(printNumberUsingThread);
            t2.start();
        }



//        helloWorld.run();

    }
}
