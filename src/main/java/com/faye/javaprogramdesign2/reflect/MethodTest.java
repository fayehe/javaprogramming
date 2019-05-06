package com.faye.javaprogramdesign2.reflect;

import java.lang.reflect.Method;

/**
 * @Author Faye F F HE
 * @Date 2019/2/26 22:48
 */
public class MethodTest {
    public void add(int a, int b){
        System.out.println(a + b);
    }
    public void outStr(String s){
        System.out.println("out: " + s);
    }

    public static void main(String[] args) throws Exception{
        Method addMethod = MethodTest.class.getMethod("add", new Class[]{int.class, int.class});
        addMethod.invoke(MethodTest.class.newInstance(), 1, 2);

        Method outMethod = MethodTest.class.getMethod("outStr", String.class);
        outMethod.invoke(MethodTest.class.newInstance(), "hello reflect invoke");
    }
}
