package AdderSubtractorSynchronisedMethod;

public class Count {
    static Integer val=0;

    public static synchronized void incrementByI(int i){
        val=val+i;
    }

    public static synchronized void decrementByI(int i){
        val=val-i;
    }
}
