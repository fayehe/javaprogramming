package com.faye.javaprogramdesign2.thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Author Faye F F HE
 * @Date 2019/6/13 20:58
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        CountDownLatch countDownLatch = new CountDownLatch(10); // 倒计时门锁
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i=0; i<10; i++)
            results.add(executorService.submit(new Worker(countDownLatch)));

        countDownLatch.await(); // 等待上面10个并发线程执行完，然后执行下面代码

        StringBuilder stringBuilder = new StringBuilder();
        for (Future<String> future : results)
            stringBuilder.append(future.get() + "~~");
        System.out.println(stringBuilder);
        executorService.shutdown();
    }
}

class Worker implements Callable<String>{
    private CountDownLatch countDownLatch;
    Worker(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public String call() {
        doSomeBusiness();
        countDownLatch.countDown();
        return Thread.currentThread().getName();
    }

    void doSomeBusiness(){
        System.out.println("worker - " + Thread.currentThread().getName() + " is doing something");
    }
}