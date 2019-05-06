package com.faye.javaprogramdesign.chapter3;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/2 20:30
 *
 * 图形面积计算

    我们有一些图形的边长数据，这些图形包括三角新和矩形，请你编写一个程序求出它们的面积。
    请你实现一个基础图形类Graph，然后实现三角形类Triangle和矩形类Rectangle，继承自Graph。根据输入的边数实现不同的对象，并计算面积。
    输入格式：
    一行，一个整数n，表示图形个数。
    n行，每行是用空格隔开的整数。
    输出格式：
    n行，每行是一个图形的面积。
    输入样例：
    2
    5 5
    6 6 6
    输出样例：
    25
    15
 */
public class GraphArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph[] graphs = new Graph[Integer.parseInt(in.nextLine())];
        for (int i=0; i<graphs.length; i++){
            String[] strings = in.nextLine().split(" ");
            if (strings.length == 2) graphs[i] = new Rectangle(strings);
            else graphs[i] = new Triangle(strings);
        }

        for (int i=0; i<graphs.length; i++){
            System.out.println((int)graphs[i].graphArea);
        }
    }
}


class Graph{ double graphArea;}
class Triangle extends Graph{
    Triangle(String[] strings){
        double  a = Double.parseDouble(strings[0]),
                b = Double.parseDouble(strings[1]),
                c = Double.parseDouble(strings[2]),
                p = (a + b + c) / 2;
        this.graphArea = Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
class Rectangle extends Graph{
    Rectangle(String[] strings){
        this.graphArea = Double.parseDouble(strings[0]) * Double.parseDouble(strings[1]);
    }
}
