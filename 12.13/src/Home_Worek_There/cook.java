package Home_Worek_There;

/**
 * 厨师线程
 */
public class cook extends Thread {
    private Integer i;

    public cook( Integer i) {
        this.i = i;
    }

    @Override
    public void run() {
        while(true){
            test();
        }
    }

    private synchronized void test() {
        if(true){
            System.out.println("厨师"+Thread.currentThread().getName()+"制作了一个面包");
            System.out.println("现有"+ ++i + "个面包");
            if(i==3){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.notifyAll();
            }
        }
    }
}
