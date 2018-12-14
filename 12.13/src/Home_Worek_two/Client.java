package Home_Worek_two;

/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) {
        new Thread(new red()).start();
        new Thread(new green()).start();
        new Thread(new yellow()).start();
    }
}
