package Home_Worek_There;

/**
 * 场景
 */
public class Client {
    public static void main(String[] args) {
        table t = new table();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    t.making();
                }
            }
        },"1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    t.making();
                }
            }
        },"2").start();
        new Thread(()->t.Take_Away(),"a").start();
        new Thread(()->t.Take_Away(),"b").start();
        /*cook c = new cook();
        guest g = new guest();
        new Thread(c,"厨师1").start();
        new Thread(c,"厨师2").start();
        new Thread(g,"客人1").start();
        new Thread(g,"客人2").start();

        new Thread(()->{
            while (true){

            }
        });*/
    }
}
