package com.faye.javaprogramdesign.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/4 23:06
 *
 * 偶数分解

歌德巴赫猜想：任何一个大于六的偶数可以拆分成两个质数的和，打印出所有的可能
输入n为偶数,输出n的所有分界可能
如输入
100
输出：
100=3+97
100=11+89
100=17+83
100=29+71
100=41+59
100=47+53

质数（prime number）又称素数，有无限个。
质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。
 */
public class EvenDecomposition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        List list = new ArrayList();

        for (int i = 3; i <= input/2; i = i + 2){
            if (judgementPrimeNumber(i) && judgementPrimeNumber(input-i))
                list.add(input + "=" + i + "+" + (input-i));
        }

        for (int i = 0; i < list.size(); i++) System.out.println(list.get(i));
    }

    public static boolean judgementPrimeNumber(int number){
        for (int j = 2; j <= Math.sqrt(number); j++){
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }
}