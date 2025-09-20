package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {

    public static void main(String[] args) {

        List<Integer> list = List.of(2,1,4,10,5,6,8,7,3,9);
        Stream<Integer> stream = list.stream();
        System.out.println(stream.limit(5).count());
        list.stream().limit(10).filter(x -> x%2==0).forEach(x->System.out.println(x));

//        Streams have 2 kinds of methods
//        intermediate method and terminal methods
//        1 stream can be used atmost once
//        once a terminal method is executed you cannot update the stream but we can apple multiple intermediate methods
//         Basically it will not improve your efficiency that much but somwetimes it do improve efficiency because it
//        internally uses a complex tree structure
        /*
        * Intermediate:-
        * limit
        * filter
        * map
        * sort
        * skip
        *
        *
        * Terminal:-
        * count
        * forEach
        * collect
        * findFirst
        * reduce
        *
        * */


                List<Integer> evenNum=list
                .stream()
                .filter(z->z%2==0)
                .collect(Collectors.toList());
        System.out.println(evenNum);

        List<Integer> evenSquared=list.
                stream()
                .filter(z->z%2==0)
                .map(x->x*x)
                .collect(Collectors.toList());
        System.out.println(evenSquared);

        List<Integer> sortedList = list.stream()
                .filter(z->z%2==0)
                .map(x->x*x)
//                .sorted()
                .sorted((a,b)->b.compareTo(a))
                .collect(Collectors.toList());

        System.out.println(sortedList);
//
//        a=[];

        List<Integer> temp = new  ArrayList<>();

        Optional<Integer> x =temp.stream()
                .filter(z->z%2==0)
                .map(y->y*y)
                .sorted((a,b)->b.compareTo(a))
                .findFirst();

        if(x.isPresent()){
            System.out.println(x.get());
        }
        else {
            System.out.println("No value present");
        }

        Integer sum =list.stream()
                .filter(z->z%2==0)
                .map(y->y*y)
                .sorted((a,b)->b.compareTo(a))
                .reduce(0,(a,b)->a+b);
        System.out.println(sum);

        Integer maxVal = list.stream()
                .filter(z->z%2==0)
                .map(y->y*y)
                .reduce(Integer.MIN_VALUE,(a,b)->Math.max(a,b));

        System.out.println(maxVal);

        Integer minVal = list.stream()
                .filter(z->z%2==0)
                .map(y->y*y)
                .reduce(Integer.MAX_VALUE,(a,b)->Math.min(a,b));
        System.out.println(minVal);





        Integer secondHighest = list.stream()
                .sorted((a,b)->b.compareTo(a))
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secondHighest);

//        Interviews SDE-1,2(20+)
// H.W.
//        flatmap (very important)
//        [[1,2,3],[4,5,6]] (input)
//        [1,2,3,4,5,6] (output)
// H.W.
//        parallel streams
//        Threads



//        MVC -> redis(cache)
//        FE -> BE -> DB
//             <-     <-
        //        FE -> BE -> Cache  DB (cache Hit)
//                    <-     <-
        //        FE -> BE -> Cache ->  DB (cache Miss)(parallel stream)
//                    <-     <-       <-






    }
}
