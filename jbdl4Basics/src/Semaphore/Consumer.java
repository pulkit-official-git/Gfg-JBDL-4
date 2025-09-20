package Semaphore;

public class Consumer implements Runnable{

    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            synchronized (store){
                if(this.store.items.size() >0){
                    this.store.consume();
                }
            }
        }
    }
}
