package com.faye.javaprogramdesign2.thread;

/**
 * @Author Faye F F HE
 * @Date 2019/1/21 20:35
 *
 */
public class CreateThreadByImplRunnable{
    public static void main(String[] args) {
        System.out.println("main method start");
        new Thread(new MyRunnable(), "thread1").start();
        new Thread(new MyRunnable(), "thread2").start();
        new Thread(new MyRunnable(), "thread3").start();
        System.out.println("main method end");


    }
}

class MyRunnable implements Runnable{
    private int sleepTime;

    MyRunnable(){ sleepTime = (int)(Math.random() * 5000); }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " will sleep for " + sleepTime);

            Thread.sleep(sleepTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
