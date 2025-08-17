package singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RedisConfig {

    String username;
    String password;
    int port;
    String url;

    private RedisConfig(String  username, String password, int port, String url) {
        this.username = username;
        this.password = password;
        this.port = port;
        this.url = url;
    }

    public static RedisConfig instance = null;
    public static Lock lock = new ReentrantLock();
    public static RedisConfig getInstance() {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new RedisConfig("root", "123456", 6379, "http://127.0.0.1:6379");
            }
            lock.unlock();
        }
        return instance;
    }






}
