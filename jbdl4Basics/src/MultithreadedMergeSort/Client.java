package MultithreadedMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newCachedThreadPool();
        List<Integer> list = List.of(10,1,9,8,4,6,7,5);

        Sorter sorter = new Sorter(list,ex);

        Future<List<Integer>> f = ex.submit(sorter);
        List<Integer> sortedArray = f.get();

        System.out.println(sortedArray);


    }
}
