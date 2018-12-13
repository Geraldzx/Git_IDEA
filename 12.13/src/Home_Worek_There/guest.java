package Home_Worek_There;

/**
 * 客人线程
 */
public class guest extends Thread{
    Integer i ;

    public guest(Integer i) {
        this.i = i ;
    }

    @Override
    public void run() {
        while(true) {
            test();
        }
    }

    private synchronized void test() {
        if (i>=3) {
            System.out.println("客人" + Thread.currentThread().getName() + "取走了一个面包");
            System.out.println("现有" + --i + "个面包");

            this.notifyAll();
        }
    }
}
