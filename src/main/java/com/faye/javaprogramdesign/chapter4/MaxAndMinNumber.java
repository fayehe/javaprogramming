package com.faye.javaprogramdesign.chapter4;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/5 11:25
 *
 * 最大公约数和最小公倍数

    输入两个正整数m和n，求其最大公约数和最小公倍数
    输入
    34 8
    输出
    2 136
 */
public class MaxAndMinNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt(), num2 = in.nextInt();
        if(num1 < num2){ int tempNum = num1; num1 = num2; num2 = tempNum; }

        int maxNum = 1; //最大公約數
        for (int i = 2; i <= num2; i++){
            if (num2 % i == 0 && num1 % i == 0) maxNum = i;
        }

        System.out.println(maxNum + " " + num1 * num2 / maxNum);
    }
}
