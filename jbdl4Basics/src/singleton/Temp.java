package singleton;

public class Temp {
    public static void test() {

        RedisConfig rc2 = RedisConfig.getInstance();
        System.out.println(rc2);

    }
}
