package Home_Worek_There;

/**
 * 桌子上的面包
 * 共享的类
 */
public class table {
    Integer i= 0;

    public Integer getIn() {
        return i;
    }

    public void setIn(Integer in) {
        this.i = in;
    }

    public table() {
    }

    public table(Integer in) {
        this.i = in;
    }

    //制作
    public synchronized void making(){
        if(true){
            System.out.println("厨师"+Thread.currentThread().getName()+"制作了一个面包");
            System.out.println("现有"+ ++i + "个面包");
            if(i>=3){
                try {
                    wait();
                    notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //取走
    public synchronized void Take_Away(){
        if (true) {
            System.out.println("客人" + Thread.currentThread().getName() + "取走了一个面包");
            System.out.println("现有" + --i + "个面包");

            if(i<=0) {
                try {
                    Thread.sleep(10000);
                    notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
