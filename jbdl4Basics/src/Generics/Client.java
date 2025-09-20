package Generics;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        Pair<String,Integer> pair = new Pair</*Optional*/>();
        pair.first="USA";
        pair.second=10;
        pair.setFirst("first");
        pair.setFirst("second");
        System.out.println(pair.getSecond());
        pair.doSomething("apple");

        pair.<String,Integer>doingSomething("apple",100);
//        pair.doingSomething(11);
        Pair.doesSomething(100);
        Pair.doesSomething("apple");


        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        Dummy.doSomething(dogs);

    }
}
