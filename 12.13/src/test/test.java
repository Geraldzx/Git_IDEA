package test;

import java.io.Serializable;

public class test {
    public static void main(String[] args) {
        new test().new tt().run();
        new test().new ttt().run();
        newThread();
        lambda();
    }

    private static void lambda() {
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("函数式编程："+i);
            }
        }).start();
    }

    private static void newThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("newthread："+i);
                }
            }
        }).start();
    }

    //实现接口
    public class tt implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("实现接口："+i);
            }
        }
    }
    //继承thread
    public class ttt extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("继承thread："+i);
            }
        }
    }
}
