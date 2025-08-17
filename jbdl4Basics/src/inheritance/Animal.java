package inheritance;

public class Animal {
    String name;
    int age;

    void printVoice(){
        System.out.println("voice");
    }
    void printAnimal(){
        System.out.println(this.name);
    }

    void printDog(String name, int age){
        System.out.println(name+" "+age);
    }

    int printDog(String name){
        System.out.println(name);
        return 0;
    }
}
