package com.faye.javaprogramdesign2.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Faye F F HE
 * @Date 2019/1/27 12:36
 *
 * 非阻塞同步实现
 */
public class ThreadSecurity2 {
    public static void main(String[] args) {

    }
}

/**
 * AtomicInteger类本身保证了其操作的同步性，因此我们不需要再额外添加同步代码，只需使用该类的实例保存需要同步数据即可。
 */
class Counter2{//非阻塞同步实现
    AtomicInteger atomicInteger = new AtomicInteger();
    public void increment(){
        atomicInteger.incrementAndGet();
    }
    public int getCount(){return atomicInteger.get();}
}

class Counter1{ //synchronized方式实现
    /**
     * volatile特性
     　　      内存可见性：通俗来说就是，线程A对一个volatile变量的修改，对于其它线程来说是可见的，即线程每次获取volatile变量的值都是最新的。

     * volatile的使用场景
     　　      通过关键字synchronize可以防止多个线程进入同一段代码，在某些特定场景中，volatile相当于一个轻量级的synchronize，因为不会引起线程的上下文切换，但是使用volatile必须满足两个条件：
     1、对变量的写操作不依赖当前值，如多线程下执行a++，是无法通过volatile保证结果准确性的;
     　　        2、该变量没有包含在具有其它变量的不变式中，这句话有点拗口，看代码比较直观。
     */
    private volatile int count = 0;
    public synchronized void increment(){
        count++; //若要线程安全执行count++，则必须加synchronized
    }
    public int getCount(){ return count;}
}
