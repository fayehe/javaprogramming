package com.faye.javaprogramdesign2.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/2/27 21:15
 *
 * 静态代理是实现代理的一种方式，这种方式比较直观，但是被代理类与代理类必须要一一对应。

    这样的话，极大的增加了类的数量，对编写和维护都是一个麻烦。

    而且在某些情况下，你还不知道被代理类到底长什么样，就需要你写出代理类，你该怎么办？

    这个时候应该使用动态代理，而Java提供了动态代理机制。

    当然首先你还是得有一个接口，以及一个实现了该接口的类，这个类就是被代理类，这两条与静态代理是一样的。接下来你就不需要写一个静态代理类了，而是要写一个动态代理类。

    当你书写一个动态代理类时，该类必须实现InvocationHandler接口。这个接口里只有一个方法：

    invoke(Object proxy,Method method, Object[] args)

    其中第一个参数proxy就是被代理的对象；第二个参数method是需要代理调用的方法；第三个参数则是参数二所表示方法的参数。

    然后就是使用Java中的Proxy类动态创建代理对象，一般而言会使用Proxy的静态方法newProxyInstance。

    newProxyInstance(ClassLoader loader,Class[]interfaces,InvocationHandler h)

    其中第一个参数指定了ClassLoader；第二个参数指定了接口，即代理对象应该实现这些接口；第三个参数则是刚才那个InvocationHandler对象。

    newProxyInstance会返回一个对象，该对象可以调用接口中所声明的那些方法。而实际上，这个动态代理对象是通过调用被代理对象的方法来完成用户的方法调用的。
    动态代理相对于静态代理最明显的区别就在于动态代理内部的被代理对象是Object，这表明我们在被代理类未知的情况下也可能可以写出代理类。这一点在平台设计上可能非常有用。

    本题提供了接口、被代理类以及主方法，学员需要自行书写一个动态代理类，已完成程序的任务。
 */
public class DynamicProxyHomework {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int x = cin.nextInt();
        int y = cin.nextInt();
        cin.close();

        //被代理对象
        IPoint point = new Point(x,y);
        //创建一个与被代理对象关联的Handler
        InvocationHandler ih = new DynamicProxyPoint(point);
        //创建一个动态代理对象
        IPoint proxy = (IPoint) Proxy.newProxyInstance(ih.getClass().getClassLoader(), Point.class.getInterfaces(), ih);
        //通过代理对象调用方法
        proxy.println();
    }
}


//动态代理类，学员请完整的完成整个动态代理类的内容
class DynamicProxyPoint implements InvocationHandler{
    /***begin your code here***/
    private Object realObj;
    DynamicProxyPoint(Object obj){ realObj = obj;}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        method.invoke(realObj, args);
        return null;
    }

    /***end your code***/
}





