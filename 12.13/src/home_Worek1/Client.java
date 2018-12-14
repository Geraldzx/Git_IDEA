package home_Worek1;

public class Client {
    public static void main(String[] args) {
        publicInt p = new publicInt();
        new Thread(()->p.add(),"1").start();
        new Thread(()->p.add(),"2").start();
        new Thread(()->p.deduct(),"a").start();
        new Thread(()->p.deduct(),"b").start();
        //no_OK();
    }

    private static void no_OK() {
        Integer i = 10;

        new Thread(new addone(i),"加1.1").start();
        new Thread(new addone(i),"加1.2").start();
        new Thread(new deductone(i),"减1.1").start();
        new Thread(new deductone(i),"减1.2").start();
    }
}
