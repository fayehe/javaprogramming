package com.faye.javaprogramdesign.chapter1;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/1 15:44
 *
 *
 * 求斐波拉契数

    斐波拉契数为，Fib(N) = Fib(N-1)+Fib(N-2) F(0)=F(1)=1 用Java编写能求Fib(N)的程序 输入为N,须输出Fib(N)
    如输入
    3
    输出：
    3
 */
public class FibolacciNumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(getFibolacciNoUseRecursion(in.nextInt()));
        System.out.println(count);
    }

    public static int count = 0;
    public static long getFibolacciNoUseRecursion(int index){ //递归版 方法调用极深 不推荐
        count++;
        if (index == 0 || index == 1) return 1;
        return getFibolacciNoUseRecursion(index-1) + getFibolacciNoUseRecursion(index-2);
    }

    public static long[] getFibolacciArray(int index){ // index > 0
        long[] fibArray = new long[index+1]; fibArray[0] = 1; fibArray[1] = 1;
        for (int i=2; i<=index; i++){
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }
        return fibArray;
    }

    public static long getFibolacciNo(int index){
        if (index == 0 || index == 1) return 1;
        long a = 1, b = 1, c = 0;
        for (int i = 1; i < index; i++){
            c = a + b;
            a = b; b = c;
        }
        return c;
    }
}
