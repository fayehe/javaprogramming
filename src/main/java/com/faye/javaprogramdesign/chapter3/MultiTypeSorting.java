package com.faye.javaprogramdesign.chapter3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/2 21:15
 *
 * 多类型排序

    我们现在有一些数据，是整数和字符串混杂的。现在需要你将他们分开，并且分别进行排序。
    请你利用泛型实现一个数组类，并且实现排序函数，使得其既可以对Integer类型进行排序，又可以对String类型进行排序。然后利用你实现的这个类完成上面的任务。
    输入格式：
    一行，一个数字n，表示元素的个数。
    n行，每行一个字符串整数，也可以是其他字符串。
    输出格式：
    n行，前面一部分为输入的整数字符串按从小到大排序输出，后面一部分为非整数字符串按照字典序从小到大输出。
    输入样例：
    5
    12
    ab
    bd
    23
    t
    输出样例：
    12
    23
    ab
    bd
    t
 */
public class MultiTypeSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] ints = new Integer[in.nextInt()];
        String[] strings = new String[ints.length];
        int j = 0, k = 0;
        for (int i = 0; i < ints.length; i++) {
            if (in.hasNextInt()) ints[j++] = in.nextInt();
            else strings[k++] = in.next();
        }
        new Sorting<Integer>(Arrays.copyOf(ints, j));
        new Sorting<String>(Arrays.copyOf(strings, k));
    }
}

class Sorting <Type>{
    Sorting(Type[] types){
        Arrays.sort(types);
        for (Type t: types) {
            System.out.println(t);
        }
    }
}