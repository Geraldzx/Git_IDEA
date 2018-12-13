package Home_Worek_There;

/**
 * 场景
 */
public class Client {
    private static int i;
    public static void main(String[] args) {

      i=0;
        new Thread(new cook(i),"厨师1").start();
        new Thread(new cook(i),"厨师2").start();
        new Thread(new guest(i),"客人1").start();
        new Thread(new guest(i),"客人2").start();

        new Thread(()->{
            while (true){

            }
        });
    }
}
