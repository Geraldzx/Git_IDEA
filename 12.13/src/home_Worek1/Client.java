package home_Worek1;

public class Client {
    public static void main(String[] args) {
        Integer i = 10;

        new Thread(new addone(i),"加1.1").start();
        new Thread(new addone(i),"加1.2").start();
        new Thread(new deductone(i),"减1.1").start();
        new Thread(new deductone(i),"减1.2").start();
    }
}
