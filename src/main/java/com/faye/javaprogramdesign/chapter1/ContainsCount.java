package com.faye.javaprogramdesign.chapter1;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/1 16:43
 * 交集
    给定两个数组(数组中不包含相同元素），求两个数组的交集中元素的个数（即共同出现的数，如没有则输出为None） 如输入：
    5
    1 2 4 6 8
    6
    1 2 5 6 7 8
    输出： 4
 */
public class ContainsCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int firstInput = in.nextInt();
        int[] firstArray = new int[firstInput];
        for (int i = 0; i < firstInput; i++){
            firstArray[i] = in.nextInt();
        }
        int secondInput = in.nextInt();
        int[] secondArray = new int[secondInput];
        for (int i = 0; i < secondInput; i++){
            secondArray[i] = in.nextInt();
        }

        int count = 0;
        for (int i = 0; i < firstInput; i++){
            for (int j = 0; j < secondInput; j++){
                if (firstArray[i] == secondArray[j]){
                    count++; break;
                }
            }
        }
        System.out.println(count == 0 ? "None" : count);

    }
}
