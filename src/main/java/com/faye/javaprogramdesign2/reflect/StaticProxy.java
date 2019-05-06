package com.faye.javaprogramdesign2.reflect;

/**
 * @Author Faye F F HE
 * @Date 2019/2/27 20:53
 */
public class StaticProxy { //客户端
    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.request();
    }
}

abstract class Subject{ //真实角色与代理角色的共同接口
    public abstract void request();
}
class RealSubject extends Subject{ //真实角色
    @Override
    public void request() {
        System.out.println("from real subject");
    }
}
class ProxySubject extends Subject{ //代理角色
    private RealSubject realSubject; //代理对象内部含有对真实对象的引用

    @Override
    public void request() {
        preRequest();//真实角色操作之前的附加操作

        if (realSubject == null) realSubject = new RealSubject();
        realSubject.request(); //真实角色完成的事情

        nextRequest();//真实角色操作之后的附加操作
    }

    private void preRequest(){
        System.out.println("do sth before real subject request");
    }
    private void nextRequest(){
        System.out.println("do sth after real subject request");
    }
}