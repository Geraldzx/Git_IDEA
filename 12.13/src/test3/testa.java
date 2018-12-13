package test3;


public class testa implements Runnable {
    Integer in;

    public testa(Integer in) {
        this.in = in;
    }

    @Override
    public void run() {
        while(in>0) ;
    }

    public synchronized void print(){
        if(in>0){
            System.out.println("线程"+Thread.currentThread().getName()+"\t出票"+in--);
        }
    }
}
