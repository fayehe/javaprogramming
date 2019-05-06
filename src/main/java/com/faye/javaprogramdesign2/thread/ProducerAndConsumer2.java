package com.faye.javaprogramdesign2.thread;

/**
 * @Author Faye F F HE
 * @Date 2019/1/23 20:43
 *
 * 修改ProducerAndConsumer，要求： 每存一张票，就售一张票，售后再存入
 */
public class ProducerAndConsumer2 {

    public static void main(String[] args) {
        Tickets2 tickets2 = new Tickets2(10);
        new Consumer2(tickets2).start();
        new Producer2(tickets2).start();
    }
}

class Tickets2{
    int number = 0; // 票号
    int size; //总票数
    boolean available = false; //表示当前是否有票可售

    Tickets2(int size){
        this.size = size;
    }

    public synchronized void put(){
        if (available){ // 如果还有存票待售，则等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer put ticket " + ++number);
        available = true;
        notify();//存票后唤醒售票线程
    }
    public synchronized void sell(){
        if (!available){// 如果没有存票待售，则等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer sell ticket" + number);
        available = false;
        notify();//售完票后唤醒存票程序
    }
}

class Producer2 extends Thread{
    Tickets2 tickets2 = null;
    Producer2(Tickets2 tickets2){
        this.tickets2 = tickets2;
    }

    public void run() {
        while (tickets2.number < tickets2.size) tickets2.put();
    }
}

class Consumer2 extends Thread{
    Tickets2 tickets2 = null;
    Consumer2(Tickets2 tickets2){
        this.tickets2 = tickets2;
    }

    public void run() {
        while (tickets2.number <= tickets2.size) tickets2.sell();
    }
}