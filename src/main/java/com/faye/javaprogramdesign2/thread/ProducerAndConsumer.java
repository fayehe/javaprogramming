package com.faye.javaprogramdesign2.thread;

/**
 * @Author Faye F F HE
 * @Date 2019/1/23 20:43
 */
public class ProducerAndConsumer {

    /*case1: 先生产完（执行一次Producer.run），再消费完（执行一次Consumer.run）
              先执行Producer的线程（一次完），再执行Consumer的线程（一次完）
    public static void main(String[] args) {
        Tickets tickets = new Tickets(10);
        new Producer(tickets).start();
        new Consumer(tickets).start();
    }*/

    //case2: 两个线程无规律的交替执行（两个线程都ready，抢资源）
    public static void main(String[] args) {
        Tickets tickets = new Tickets(10);
        new Consumer(tickets).start();
        new Producer(tickets).start();

    }
}

class Tickets{
    int number = 0; // 票号
    int size; //总票数
    boolean available = false; //表示当前是否有票可售

    Tickets(int size){
        this.size = size;
    }
}
class Producer extends Thread{
    Tickets tickets = null;
    Producer(Tickets tickets){
        this.tickets = tickets;
    }
    @Override
    public void run() {
        while (tickets.number < tickets.size){
            synchronized (tickets) {
                System.out.println("Producer puts ticket " + ++tickets.number);
                tickets.available = true;
            }
        }
    }
}
class Consumer extends Thread{
    Tickets tickets = null;
    int i = 0;
    Consumer(Tickets tickets){
        this.tickets = tickets;
    }
    @Override
    public void run() {
        while (i < tickets.size){
            //case4：与Producer一起同步后，case3中死循环将不会出现，恢复正常
            synchronized (tickets) { //申请对象tickets的锁
                if (tickets.available && i <= tickets.number)
                    System.out.println("Consumer buys ticket " + ++i);
                if (i == tickets.number) {
                    // case3：辅助case2，会出现错误 —— 死循环
                    try { Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}

                    tickets.available = false;
                } //释放对象的锁
            }
        }
        System.out.println("consumer end");
    }
}