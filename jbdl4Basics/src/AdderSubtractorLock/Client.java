package AdderSubtractorLock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Lock lock = new ReentrantLock();
        ExecutorService ex = Executors.newCachedThreadPool();
        Count c = new Count();
        Adder adder = new Adder(c,lock);
        Subtractor subtractor = new Subtractor(c,lock);
        Future<Integer> f1 = ex.submit(adder);
        Future<Integer> f2 = ex.submit(subtractor);
        f1.get();
        f2.get();
        System.out.println(c.val);
    }
}
