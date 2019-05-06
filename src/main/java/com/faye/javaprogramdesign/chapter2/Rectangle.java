package com.faye.javaprogramdesign.chapter2;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/1 18:46
 *
 * 创建一个简单的表示矩形的Rectangle类，满足以下条件：

    1、定义两个成员变量height和width，表示矩形的长和宽，类型为整型
    2、定义一个getArea方法，返回矩形的面积
    3、定义一个getPerimeter方法，返回矩形的周长
    4、在main函数中，利用输入的2个参数分别作为矩形的长和宽，调用getArea和getPermeter方法，计算并返回矩形的面积和周长

    输入：
    输入2个正整数，中间用空格隔开，分别作为矩形的长和宽，例如：5 8

    输出：
    输出2个正整数，中间用空格隔开，分别表示矩形的面积和周长，例如：40 26
 */
public class Rectangle {
    Rectangle(int b){
        width = b;
    }

    Rectangle(int n, int b){
        this(b);
        height = n;
    }
    static int height, width;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        height = in.nextInt();
        width = in.nextInt();
        System.out.println(getArea() + " " + getPerimeter());
    }

    static int getArea(){
        return height * width;
    }

    static int getPerimeter(){
        return 2 * (height + width);
    }
}
