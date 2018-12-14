package Home_Worek_There;

/**
 * 客人线程
 */
public class guest extends Thread{
    table t = new table();
    @Override
    public void run() {
        while(true) {
            test();
        }
    }

    private synchronized void test() {
        t.Take_Away();
    }
}
