package singleton;

public class Client {
    public static void main(String[] args) {

        RedisConfig redisConfig = RedisConfig.getInstance();
        System.out.println(redisConfig);
        Temp temp = new Temp();
        Temp.test();

    }
}
