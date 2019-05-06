package com.faye.javaprogramdesign2.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/2/25 21:32
 *
 * 单词计数  (100 满分)
    题目描述
    编写一个程序，从键盘输入一个个单词，每接收到一个单词后，输出该单词曾经出现过的次数，接收到“QUIT”单词后程序直接退出。

    建议使用HashMap来解决该问题


    题目已经给出了必要的输入代码，学员只需完成统计与输出功能代码即可。

    为了保证解答的灵活性，题目并不强制要求学员定义HashMap来解决问题，学员也可以定义别的数据结构来尝试本题。提醒一下：如果使用了别的数据结构，需要import相应的文件。
 */
public class HashMapCounter {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //此处需要定义一个HashMap(建议)
        /***begin your code here***/
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        /***end your code***/
        while(true) {
            String s = cin.nextLine();
            if("QUIT".equals(s)) break;

            //以下完成统计及输出功能的代码
            /***begin your code here***/
            int val = wordMap.get(s) == null ? 0 : wordMap.get(s);
            System.out.println(val);
            wordMap.put(s, val+1);

            /***end your code***/
        }
        cin.close();
    }
}
