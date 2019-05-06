package com.faye.javaprogramdesign2.thread;

import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Faye F F HE
 * @Date 2019/1/27 12:36
 */
public class ThreadSecurity { // 1.1 synchronized 方式
    private static Vector<Integer> vector = new Vector<Integer>();

    /**
     * 此方法平常好着，偶尔会出错： ArrayIndexOutOfBoundsException
     *
     * Exception in thread "Thread-3400" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 7
         at java.util.Vector.remove(Vector.java:831)
         at com.faye.javaprogramdesign2.thread.ThreadSecurity$1.run(ThreadSecurity.java:22)
         at java.lang.Thread.run(Thread.java:748)
     *
     *
     * 通过同步，可以解决此类线程安全问题
     */
    public static void main(String[] args) {
        while (true){
            for (int i=0; i<10; i++){
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) { // 加上同步机制
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });

            removeThread.start();
            printThread.start();
            while (Thread.activeCount() > 20) ;
        }
    }
}

class ThreadSecurityByReentrantLock {// 1.2 ReentrantLock.lock/unlock方式
    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadSecurityByReentrantLock threadSecurity2 = new ThreadSecurityByReentrantLock();
        threadSecurity2.write();
        threadSecurity2.read();
    }

    public void write(){
        reentrantLock.lock();
        try {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buff中写入数据");
            for (;;){ //模拟很长时间
                if (System.currentTimeMillis() - startTime > 5000) break;
            }
            System.out.println("终于写完了");
        } finally {
            reentrantLock.unlock(); // 解锁
        }
    }

    public void read() {
        try {
            reentrantLock.lockInterruptibly(); // 如果当前线程未被中断，则获取锁
            System.out.println("从这个buff中读数据");
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally{
            reentrantLock.unlock();
        }
    }
}

