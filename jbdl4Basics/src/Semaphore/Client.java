package Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        for(int i=1;i<=8;i++){
            executorService.submit(producer);
        }

        for(int i=1;i<=5;i++){
            executorService.submit(consumer);
        }

    }
}
