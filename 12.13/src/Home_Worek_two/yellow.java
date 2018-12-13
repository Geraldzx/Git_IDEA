package Home_Worek_two;

/**
 * 黄色线程
 */
public class yellow extends Thread {
    Integer i=0;
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true) {

            System.out.println("黄灯亮--第" + ++i + "下");
            if (i == 3) {
                i = 0;
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
