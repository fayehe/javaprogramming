package com.faye.javaprogramdesign.chapter4;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/5 12:07
 *
 * 铺砖问题

    有两种砖，分别是1*1的砖和1*2的砖，用这两种砖铺1*N的地面，问共有多少种铺法。输入为N，请输出相应的铺法数
    输入：
    3
    输出：
    3


    假设目标函数为f(N)，N>2的时候第一块砖可以选择1*1或1*2，
        选择1*1后面的铺法是f(N-1)，
        选择1*2后面的铺法是f(N-2)，所以
    f(N)=f(N-1)+f(N-2)
 */
public class BrickLayingProblem {
    public static void main(String[] args) {
        int inputN = new Scanner(System.in).nextInt();
        System.out.println(getFibolacciNo(inputN));
    }

    public static long getFibolacciNo(int index){
        if (index == 1) return 1;
        if (index == 2) return 2;
        long i1 = 1, i2 = 2, i3 = 3;
        for (int i = 3; i <= index; i++){
            i3 = i1 + i2;
            i1 = i2;
            i2 = i3;
        }
        return i3;
    }

    //排列組合：在总数n之中选取m个数 的 取法总数
    public static int paiLieZuHe(int n, int m){
        if (m > n / 2) m = n - m;
        if (m == 0) return 1;

        int temp1 = 1, temp2 = 1;
        while (m > 0){
            temp1 *= n--; temp2 *= m--;
        }
        return temp1 / temp2;
    }

}
