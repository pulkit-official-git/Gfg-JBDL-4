package AdderSubtractorLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Integer> {
    Count count;
    Lock lock;

    public Adder(Count count,Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public Integer call() throws Exception {
        lock.lock();
        for(int i=1;i<1000;i++){
            this.count.val+=i;
        }
        lock.unlock();
        return count.val;
    }
}
