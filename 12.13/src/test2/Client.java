package test2;

public class Client {
    public static void main(String[] args) {
        test t = new test();

        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
