package com.faye.javaprogramdesign.chapter2;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/1 20:42
 *
 * 编写一个三角形类，能根据输入的3个double类型数据构造三角形对象，定义三个构造方法。
    如果这3个数据满足构成三角形的条件，直接构造三角形。否则，如果3个数的最大值大于0，则自动构造以最大值为边的等边三角形。如果最大值也不大于0，则将三角形类的三边都初始化为0。
    再定义一个getArea方法，计算所构造的三角形的面积，返回类型为double。
    最后，编写main方法，测试getArea方法，计算三角形的面积。

    输入：
    输入三个有理数，中间用空格隔开。例如：
    8.9 6.4 7.2

    输出：
    输出三角形的面积。例如：
    22.78812396293297
 */
public class TriangularArea {
    double a, b, c;
    TriangularArea(){}
    TriangularArea(double a){ this.a = a;}
    TriangularArea(double a, double b, double c){
        if (a < 0 || b < 0 || c < 0 || a + b <= c || a + c <= b || b + c <= a){
            b = Math.max(a, b);
            c = Math.max(b, c);
            if (c > 0) this.a = this.b = this.c = c;
            else this.a = this.b = this.c = 0;
        }else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TriangularArea triangularArea = new TriangularArea(in.nextDouble(), in.nextDouble(), in.nextDouble());
        System.out.println(triangularArea.getArea());
    }

    private double getArea(){
        double p = (a + b + c) / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
