package com.faye.javaprogramdesign2.thread;

/**
 * @Author Faye F F HE
 * @Date 2019/1/21 20:35
 *
 */
public class CreateThreadByExtendsThread{
    public static void main(String[] args) {
        System.out.println("main method start");
        new MyThread(6).start();
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main method end");
    }

    /*public static void main(String[] args) {
        BackgroundThread backgroundThread = new BackgroundThread();
        backgroundThread.setDaemon(true);
        backgroundThread.start();
        System.out.println("main thread");
    }*/
}

class MyThread extends Thread{
    private int num;//私有成员

    MyThread(int num){this.num = num;}

    @Override
    public void run() {
        int result = 1;
        System.out.println("new thread start");
        while (num > 0){
            result *= num--;
        }
        System.out.println(result);
        System.out.println("new thread end");
    }
}

class BackgroundThread extends Thread{
    @Override
    public void run() {
        while (true) System.out.println("background thread");
    }
}
