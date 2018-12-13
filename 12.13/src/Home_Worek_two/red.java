package Home_Worek_two;

/**
 * 红灯线程
 */
public class red extends Thread {
    Integer i=0;
    @Override
    public void run() {
        while(true){
        System.out.println("红灯亮--第"+ ++i +"下");
        if(i==5) {
            i = 0;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }
}
