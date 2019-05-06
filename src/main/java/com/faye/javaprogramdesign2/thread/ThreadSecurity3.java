package com.faye.javaprogramdesign2.thread;

/**
 * @Author Faye F F HE
 * @Date 2019/1/27 18:06
 *
 * 无同步方案 - 线程本地存储
 */
public class ThreadSecurity3 {
    private static ThreadLocal<Integer> sequenceNumber = new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum(){
        sequenceNumber.set(sequenceNumber.get() + 1);
        return sequenceNumber.get();
    }

    public static void main(String[] args) {
        ThreadSecurity3 threadSecurity3 = new ThreadSecurity3();
        TestClient testClient1 = new TestClient(threadSecurity3);
        TestClient testClient2 = new TestClient(threadSecurity3);
        TestClient testClient3 = new TestClient(threadSecurity3);
        testClient1.start();
        testClient2.start();
        testClient3.start();
    }

    private static class TestClient extends Thread{
        private ThreadSecurity3 ts3;
        TestClient(ThreadSecurity3 ts3){ this.ts3 = ts3;}

        @Override
        public void run() {
            for (int i=0; i<3; i++){
                System.out.println(Thread.currentThread().getName() + "'s sequence number is " + ts3.getNextNum());
            }
        }
    }
}


