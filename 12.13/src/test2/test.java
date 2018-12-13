package test2;

public class test extends Thread{
    private int num=20;
    @Override
    public void run() {
      while(num>0) this.out();
    }
    public synchronized void out(){
        if(num>0){
            System.out.println("线程"+Thread.currentThread().getName()+ "\t出票" + num--);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
