package Home_Worek_two;

/**
 * 绿色线程
 */
public class green extends Thread {
        Integer i=0;
        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(true) {
                System.out.println("绿灯亮--第" + ++i + "下");
                if (i == 5) {
                    i = 0;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
