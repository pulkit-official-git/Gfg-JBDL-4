package SemaphoreUltimate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);
        Semaphore pS = new Semaphore(5);
        Semaphore cS = new Semaphore(0);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        Producer producer = new Producer(store,pS,cS);
//        Consumer consumer = new Consumer(store,pS,cS);
//        executorService.submit(producer);
//        executorService.submit(consumer);

        for(int i=1;i<8;i++){
//            Producer producer = new Producer(store,pS,cS);
            executorService.submit(new Producer(store,pS,cS));
        }

        for(int i=1;i<5;i++){
//            Consumer consumer = new Consumer(store,pS,cS);
            executorService.submit(new Consumer(store,pS,cS));
        }

    }
}
