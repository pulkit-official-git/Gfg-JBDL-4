package MultithreadedMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    List<Integer> integers;
    ExecutorService ex;

    public Sorter(List<Integer> list, ExecutorService ex) {
        this.integers = list;
        this.ex = ex;
    }

    @Override
    public List<Integer> call() throws Exception {

        if(integers.size()<=1){
            return integers;
        }

        int mid =  integers.size()/2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            left.add(integers.get(i));
        }
        for (int i = mid; i < integers.size(); i++) {
            right.add(integers.get(i));
        }

        Sorter s1 = new Sorter(left,ex);
        Sorter s2 = new Sorter(right,ex);

        Future<List<Integer>> f1 = ex.submit(s1);
        Future<List<Integer>> f2 = ex.submit(s2);

        left = f1.get();
        right = f2.get();

        List<Integer> sortedList = new ArrayList<>();

        int i=0,j=0;
        while(i<left.size()&&j<right.size()){
            if(left.get(i)<=right.get(j)){
                sortedList.add(left.get(i++));
            }
            else{
                sortedList.add(right.get(j++));
            }
        }
        while(i<left.size()){
            sortedList.add(left.get(i++));
        }
        while(j<right.size()){
            sortedList.add(right.get(j++));
        }
        return sortedList;
    }
}
