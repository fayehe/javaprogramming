package com.faye.javaprogramdesign2.thread;

/**
 * @Author Faye F F HE
 * @Date 2019/1/22 8:04
 */
public class SharedSession {
    /*public static void main(String[] args) {
        final int n = 4; // 使用final变量使子线程共享主线程的数据
        new Thread(new Runnable()  {
            @Override
            public void run() {
                int i = n;
                int result = 1;
                while (i > 0){
                    result *= i--;
                }
                System.out.println(result);
                System.out.println("new thread end");
            }
        }).start();
        System.out.println("main thread end");
    }*/

    /*public static void main(String[] args) { // 共享MyRunnable中的成员变量sleepTime
        MyRunnable myRunnable = new MyRunnable();
        System.out.println("main method start");
        new Thread(myRunnable, "thread1").start();
        new Thread(myRunnable, "thread2").start();
        new Thread(myRunnable, "thread3").start();
        System.out.println("main method end");
    }*/

    public static void main(String[] args) {
        SellTickets sellTickets = new SellTickets();
        System.out.println("main method start");
        new Thread(sellTickets).start();
        new Thread(sellTickets).start();
        new Thread(sellTickets).start();
        System.out.println("main method end");
    }

    /* out: has error.
    main method start
    main method end
    Thread-0 is selling ticket 200
    Thread-0 is selling ticket 199
    Thread-0 is selling ticket 198
    Thread-0 is selling ticket 197
    Thread-0 is selling ticket 196
    Thread-0 is selling ticket 195
    Thread-0 is selling ticket 193
    Thread-1 is selling ticket 200*/

}

class SellTickets implements Runnable{
    private int tickets = 200;

    @Override
    public void run() {
        while (tickets > 0){
            System.out.println(Thread.currentThread().getName() + " is selling ticket " + tickets--);
        }
    }
}
