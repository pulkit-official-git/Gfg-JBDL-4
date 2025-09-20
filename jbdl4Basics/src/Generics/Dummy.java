package Generics;

import java.util.List;

public class Dummy {

    public static void doSomething(List< ? extends Animal> animals) {
//
//        animals.add(new Cat());
//        animals.add(new Dog());
//        animals.add(new Animal());
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal);
        }
//        System.out.println();

    }

    public static <T extends Animal>void doingSomething(List<T> animals) {
//
//        animals.add(new Cat());
//        animals.add(new Dog());
//        animals.add(new Animal());
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal);
        }
//        System.out.println();

    }

    public static void doesSomething(List< Dog> animals) {
//
//        animals.add(new Cat());
        animals.add(new Dog());
//        animals.add(new Animal());
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal);
        }
//        System.out.println();

    }


}
