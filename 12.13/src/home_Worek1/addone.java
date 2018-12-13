package home_Worek1;

public class addone extends Thread{
    Integer i;

    public addone(Integer i) {
        this.i = i;
    }

    @Override
    public  void run() {
        while (20>i&&i>0) {
            test();
        }
    }

    private synchronized void test() {
        if(20>i&&i>0)
        System.out.println("线程" + Thread.currentThread().getName() +"\t"+ i++);
    }
}
