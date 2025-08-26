package AdderSubtractor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newCachedThreadPool();
        Count c = new Count();
        Adder adder = new Adder(c);
        Subtractor subtractor = new Subtractor(c);
        Future<Integer> f1 = ex.submit(adder);
        Future<Integer> f2 = ex.submit(subtractor);
        f1.get();
        f2.get();
        System.out.println(c.val);
    }
}
