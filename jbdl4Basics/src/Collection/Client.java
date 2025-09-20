package Collection;

import java.util.*;

public class Client {
    public static void main(String[] args) {

//        Integer [] arr = new Integer[]{5,3,1,6,8,3,2,4,9};
//        Arrays.sort(arr,new  Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

//        List<Integer> num = Arrays.asList(5,4,2,3,1,10,7);
//        List<Integer>num = List.of(3,4,6,1,2,8,9,7,5,4,9);
//        num.add(6);
//        System.out.println(type(num));
//        Collections.sort(num, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        for(Integer i : num){
//            System.out.println(i);
//        }

        List<Student> students = new ArrayList<>();
        students.add(new Student("ram",20,123,70));
        students.add(new Student("sham",30,234,50));
        students.add(new Student("nam",20,321,90));
        students.add(new Student("gam",10,213,10));

        Collections.sort(students);
        for(Student s : students){
            System.out.println(s.name + " "+ s.rollNumber + " "+ s.age);
        }

        Collections.sort(students,new StudentAgeComparator());
        for(Student s : students){
            System.out.println(s.name + " "+ s.rollNumber + " "+ s.age);
        }


    }
}
