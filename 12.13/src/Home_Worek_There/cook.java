package Home_Worek_There;

/**
 * 厨师线程
 */
public class cook extends Thread {
   table t = new table();
    @Override
    public void run() {
        while(true){
            test();
        }
    }

    private synchronized void test() {
         t.making();
    }
}
