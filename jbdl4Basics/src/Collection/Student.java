package Collection;

public class Student implements Comparable<Student>{

    String name;
    Integer age;
    Integer rollNumber;
    Integer score;

    public Student(String name, int age, int rollNumber, int score) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.rollNumber.compareTo(o.rollNumber);
//        return this.name.compareTo(o.name);
    }

}
