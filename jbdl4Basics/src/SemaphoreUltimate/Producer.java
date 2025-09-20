package SemaphoreUltimate;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    Store store;
    Semaphore ps;
    Semaphore cs;

    public Producer(Store store, Semaphore ps, Semaphore cs) {
        this.store = store;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public void run() {

        while(true){
//            if(this.store.items.size()>= store.maxSize){
//                System.out.println("Max size exceeded");
//                return;
//            }

            try {
                ps.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            [011] 3 2 1
            if(this.store.items.size()<this.store.maxSize){
                    this.store.produce();
                }

            cs.release();
        }

    }
}
