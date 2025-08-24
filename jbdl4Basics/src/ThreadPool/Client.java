package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

//        ExecutorService pool = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 100000; i++) {
//            if(i==800){
//                int x=10;
//            }
//            PrintNumbers printNumbers = new PrintNumbers(i);
//            pool.submit(printNumbers);
//        }

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000000; i++) {
            if(i==800){
                int x=10;
            }
            PrintNumbers printNumbers = new PrintNumbers(i);
            pool.submit(printNumbers);
        }


    }
}
