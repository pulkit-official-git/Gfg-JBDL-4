package OOPs;

public class User {

    String name;
    int age;
    String email;

    User(){

    }

     User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
