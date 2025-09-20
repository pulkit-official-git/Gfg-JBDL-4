package SemaphoreUltimate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    int maxSize;
    ConcurrentLinkedDeque<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ConcurrentLinkedDeque<>();
    }

    public void produce(){
//        Lock lock = new ReentrantLock();
//        lock.lock();
        this.items.add(new Object());
        synchronized(System.out) {
            System.out.println("Producer produced " + this.items.size() + " items");
        }
//        lock.unlock();
    }

    public void consume(){
//        this.items.remove(items.size()-1);
//        Lock lock = new ReentrantLock();
//        lock.lock();
        this.items.remove();
        synchronized(System.out) {
            System.out.println("Consumer consumed " + this.items.size() + " items");
        }
//        lock.unlock();
    }


}
