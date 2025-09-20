package LambdasStreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Client {
    /*
    * Functional Interfaces
    *
    * Comparator
    * Comparable
    * Runnable
    * Callable
    *
    * */

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Ram",20,123,50));
        students.add(new Student("Sham",21,234,40));
        students.add(new Student("Calm",19,345,70));
        students.add(new Student("dam",22,456,90));

//        Collections.sort(students);
//
//        for(Student s : students){
//            System.out.println(s.name + " "+ s.rollNumber + " "+ s.age);
//        }


//        Way1
//        Collections.sort(students,new StudentAgeComparator());
//
//        for(Student s : students){
//            System.out.println(s.name + " "+ s.rollNumber + " "+ s.age);
//        }

//        Way2
//        ()->{}  Lambda expression
//        Collections.sort(students,(Student o1, Student o2)->{
//            return o1.age.compareTo(o2.age);
//        });
//
//        for(Student s : students){
//            System.out.println(s.name + " "+ s.rollNumber + " "+ s.age);
//        }

//        Way3
//        Collections.sort(students,(a,b)->{
//            return b.score.compareTo(a.score);
//        });
//        for(Student s : students){
//            System.out.println(s.name + " "+ s.rollNumber + " "+ s.age);
//        }

        //    Way4
        Collections.sort(students,(a,b)->a.score.compareTo(b.score));
        for(Student s : students){
            System.out.println(s.name + " "+ s.rollNumber + " "+ s.age + " "+ s.score);
        }

//        Way5
//        Collections.sort(students,a->a*a); // this will not work because we need 2 input parameters but if u
//                                                      have a single parameter  you can ignore the parenthesis.

        Runnable r1 = ()->{
            System.out.println("Running r1");
        };

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(()->{
            System.out.println("Running t2");
        });
        t2.start();

//        Creating a functional interface

        Calculator add = (a,b)-> {return a+b;};
        System.out.println(add.operate(1,2));

        Calculator mul = (y,z)-> y*z;
        System.out.println(mul.operate(10,20));

        Calculator sub = (a,b)-> {
            if(a<b){
                return b-a;
            }
            return a-b;
        };
        System.out.println(sub.operate(20,10));


//        Calculator mul2 = ((a,b)->{return a+b;});
//        Calculator sub2 =  sub::operate;
//        System.out.println(sub2.operate(10,20));
//        System.out.println(mul.operate(10,20));


        //    Way5
        Collections.sort(students,(Student::compareTo));
        for(Student s : students){
            System.out.println(s.name + " "+ s.rollNumber + " "+ s.age + " "+ s.score);
        }

//        Calculator c10 = Calculator::operate;


//            forst rule :- we skip ->
//          second rule data is skipped



    }




}
