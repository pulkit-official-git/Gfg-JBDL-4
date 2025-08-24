package Threads;

public class PrintNumberUsingThread implements Runnable {

    int noToPrint;

    public PrintNumberUsingThread(int noToPrint) {
        this.noToPrint = noToPrint;
    }

    @Override
    public void run() {
        System.out.println(noToPrint + " " + Thread.currentThread().getName());
    }
}
