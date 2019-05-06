package com.faye.javaprogramdesign.chapter1;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/1 15:33
 *
 * 字符串排序
    用Java编写一个能对一组字符串按字典序升序排序的程序 输入为N和N行字符串，需要按行输出字符串升序排序的结果 如输入
    3
    Abc
    Abe
    Abd
    输出：
    Abc
    Abd
    Abe
 */
public class SortString {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int stingNum = in.nextInt();
        String[] stringArray = new String[stingNum];
        for (int i=0; i<stingNum; i++){
            stringArray[i] = in.next();
        }

//        Arrays.sort(stringArray);
        for (int i=0; i<stingNum; i++){
            for (int j=0; j<stingNum-i-1; j++){
                if (stringArray[j].compareTo(stringArray[j+1]) > 0){
                    String tempStr = stringArray[j];
                    stringArray[j] = stringArray[j+1];
                    stringArray[j+1] = tempStr;
                }
            }
        }

        for (int i=0; i<stingNum; i++){
            System.out.println(stringArray[i]);
        }
    }

}
