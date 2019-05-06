package com.faye.javaprogramdesign2.reflect;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/2/27 21:15
 *
 * 代理是一种设计模式。

    所谓设计模式，就是一些代码编写的套路。

    这些套路一般而言与功能无关，而与代码的复用性、扩展性有关。

    想象一下，你刚进到一家公司，老板要你把某个软件从1.0升级到2.0。

    你会从零开始编写2.0，还是在1.0的基础上进行扩展？

    基本上，大家都会在已有的代码基础上进行升级、扩写。

    这个时候，1.0代码的编写套路就很重要了，好的套路可以让后来者比较容易的实现扩展，而不好的套路......

    因此，人们总结了各种套路，适用不同情况下的代码复用与扩展。代理就是其中一种套路。

    静态代理又是代理中最简单的一种实现方式。

    一般而言，一个完整的静态代理包括3个部分。

    首先是一个接口，规定了需要实现的方法。本题中即IPoint。

    其次是一个实现类，实现了接口中规定的方法。本题中即Point类。

    最后是一个代理类，通过调用实现类中的方法来实现接口。本题中即ProxyPoint类。

    顺便说一句，教材上的例子以及作业的例子一般而言完全体现不出代理的必要性，不用代理也完全可以完成题目的要求。本题也是如此。

    这是显然的，因为设计模式本就不是针对功能实现的，而是针对代码的复用性与扩展性。而且，每一种具体的模式都是针对具体环境的。

    笼统的说，设计模式只有在代码的升级换代、改造更新中才能体现出效果。

    如果你的代码只为了功能实现，或者说你的代码肯定不会升级，那么设计模式没有任何用处。

    典型的例子就是你现在所做的作业。当你完成了这个作业指定的任务，你的任务就完成了。你不会再来升级更新这份代码，对不对？

    无论如何，本题还是希望你能写出一个代理。本题已经提供了绝大部分代码，学员只需完成静态代理类本身。另一方面，学员最好仔细跟踪一下程序运行的流程，看看最后的功能到底是如何完成的。
 */
public class StaticProxyHomework {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int x = cin.nextInt();
        int y = cin.nextInt();
        cin.close();

        //创建一个代理类，并调用相应的方法
        //此处模仿客户端操作，客户"只能"创建了代理类的实例
        //但是归根到底，是实现类的方法实现了指定功能
        IPoint pp = new ProxyPoint(x,y);
        pp.println();
    }
}

//接口，规定了方法
interface IPoint{
    public void println();
}

//实现类，方法在此类中实现
class Point implements IPoint{
    //实现类的私有成员
    private int x;
    private int y;

    //实现类的构造器
    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }

    //实现类实现了接口的方法
    @Override
    public void println() {
        System.out.println("("+x+","+y+")");
    }
}

//代理类，出于某种理由，客户不能访问Point类，只能访问ProxyPoint类
class ProxyPoint implements IPoint{
    //代理类持有实现类的一个实例
    private Point point;

    //学员需要编写代理类的构造器
    public ProxyPoint(int x,int y) {
        /***begin your code here***/
        if(point == null) point = new Point(x, y);
        /***end your code***/
    }

    //学员需要实现代理类的接口方法
    @Override
    public void println() {
        /***begin your code here***/
        point.println();
        /***end your code***/
    }
}




