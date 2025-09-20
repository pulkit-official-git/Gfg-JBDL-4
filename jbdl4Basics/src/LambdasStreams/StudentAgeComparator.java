package LambdasStreams;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.age == o2.age){
            return o1.rollNumber.compareTo(o2.rollNumber);
        }
        return o2.age.compareTo(o1.age);
    }
}
