package Semaphore;

public class Producer implements Runnable{

    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        while(true){
            synchronized (store){
                if(this.store.items.size()<this.store.maxSize){
                    this.store.produce();
                }
            }
        }

    }
}
