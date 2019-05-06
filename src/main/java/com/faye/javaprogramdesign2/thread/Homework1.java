package com.faye.javaprogramdesign2.thread;
import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/24 21:17
 *
 * 用SYNCHRONIZED修饰方法实现线程同步  (100/100 分数)
    题目描述
    给定若干个正int，求这些正整数的最小质因子之和。1的最小质因子就认为是1。

    特别的，程序要求为每一个参数创建一个子线程，并在该子线程中求出其最小质因子。

    并将这个质因子累加到一个指定的变量中。

    主线程最后会输出该指定变量，作为结果。

    学员的任务就是补全Result类的代码，使得整个程序能够正确执行。

    具体而言，学员需要正确的设计Result类的私有成员变量以及若干公有成员方法，同时——也是本题的最主要的目标——注意正确使用同步机制。

    本题不提供输入输出样例，请仔细阅读源代码中的注释。

    按照注释要求补全代码。
 */

class Result{
    //本题学员的任务就是补全Result类，使整个程序能够正确的运行

    /***begin your code here***/
    private int value;

    Result(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public synchronized void addValue(int t){
        value += t;
    }

    /***end your code***/
}

public class Homework1{
    public static void main(String[]args){
        //根据指定的方法生成输入
        int [] input = getInput();

        //定义一个Result实例，用于保存计算结果
         final Result result = new Result(0);

        //对每一个输入的参数
        //利用匿名Thread与匿名Runnable创建并执行一个子线程
        for(final int n:input) {
            new Thread(new Runnable() {@Override public void run() {
                //此处求取n的最小质因子，如果n是1，认为答案就是1
                int t = 1;
                for(int i=2;i!=n+1;++i) if(0==n%i){t=i;break;}
                //t就是答案，将t累加进result
                result.addValue(t);
            }}).start();
        }

        //主线程暂时不和子线程做任何同步，简单的等待300ms之后，直接输出result(这样做当然是由隐患的)
        try {Thread.sleep(300L);}catch (InterruptedException e) {e.printStackTrace();}
        System.out.println(result.getValue());
    }

    //本方法用于生成输入参数，学员可以无视
    public static int [] getInput(){
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int m = cin.nextInt();
        int x = cin.nextInt();
        cin.close();

        int [] ret = new int [100];
        for(int i=0;i!=100;++i) {
            x = ( a * x + b ) % m;
            ret[i] = x;
        }
        return ret;
    }
}



class Homework2{
    //直接定义一个基本类型用于保存结果
    static int result = 0;

    //这个数组专门用于为同步提供对象
    //因为基本类型不能直接用于同步
    static int [] a = new int [0];

    public static void main(String[]args){
        //根据指定的方法生成输入
        int [] input = Homework1.getInput();

        //对每一个输入的参数
        //利用匿名Thread与匿名Runnable创建并执行一个子线程
        for(final int n:input) {
            new Thread(new Runnable() {@Override public void run() {
                //此处求取n的最小质因子，如果n是1，认为答案就是1
                int t = 1;
                for(int i=2;i!=n+1;++i)if(0==n%i){t=i;break;}

                //在此补全代码，将n的最小质因子（即上面求出的t）累加至result
                //注意做同步
                /***begin your code here***/
                synchronized (a) {
                    result += t;
                }
                /***end your code***/
            }}).start();
        }

        //主线程暂时不和子线程做任何同步，简单的等待300ms之后，直接输出result（当然这是有隐患的）
        try {Thread.sleep(300L);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println(result);
    }
}

class Homework3 {
    //直接定义一个基本类型用于保存结果
    static int result = 0;
    //这个数组专门用于为同步提供对象
    //因为基本类型不能直接用于同步
    static int [] a = new int [0];
    public static void main(String[] args) {
        //根据指定的方法生成输入
        int [] input = Homework1.getInput();

        //对每一个输入的参数，创建并执行一个子线程
        for(final int n:input) {
            //创建一个具名对象表示一个完成指定任务的线程
            Thread thread = new Thread(new Runnable(){@Override public void run(){
                int t = 1;
                for(int i=2;i!=n+1;++i)if(0==n%i){t=i;break;}
                //将t累加至结果，此处需要做同步
                synchronized(a){result+=t;}
            }});
            //执行该线程
            thread.start();
            //在这里敲入代码保证主线程能够正确等待直到所有子线程结束
            /***begin your code here***/
            try {
                thread.join(); // waits for this thread to die.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /***end your code***/
        }

        //要确保子线程结束以后才在主线程打印该结果
        //考虑一下在上面创建并执行子线程的时候，还应该做什么
        System.out.println(result);
    }
}

