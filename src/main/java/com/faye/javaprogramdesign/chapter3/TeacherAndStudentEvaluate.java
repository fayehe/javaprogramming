package com.faye.javaprogramdesign.chapter3;

import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/1/1 22:43
 *
 * 教师学生评分

    学校要进行年终总结，需要对教师和学生的评分结果进行统计。学生的统计数据有三个，教师的统计数据有四个。请你实现一个统计系统，对输入的数据进行整理。
    请你实现一个Person类表示人员，并实现一些必要的方法，再实现Teacher类和Student类，通过类的继承机制完成这个任务。
    输入格式：
    首先输入一个数字N，表示输入统计的人数。
    接下来是N行，每行是用空格隔开的一系列数字。
    输出格式：
    N行，每行是一个标识符加一个平均得分（向下取整的整数），用空格隔开。
    学生的标识符是Student，教师的标识符是Teacher。
    输入样例：
    2
    2 3 4
    2 3 4 5
    输出样例：
    Student 3
    Teacher 3
 */
public class TeacherAndStudentEvaluate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Person[] persons = new Person[in.nextInt()];
        String lineStr = in.nextLine();
        for (int i=0; i<persons.length; i++){
            lineStr = in.nextLine();
            String[] lineStrs = lineStr.split(" ");
            if (lineStrs.length == 3) {
                persons[i] = new Student((Integer.parseInt(lineStrs[0]) + Integer.parseInt(lineStrs[1]) + Integer.parseInt(lineStrs[2])) / 3);
            }else if (lineStrs.length == 4){
                persons[i] = new Teacher((Integer.parseInt(lineStrs[0]) + Integer.parseInt(lineStrs[1]) + Integer.parseInt(lineStrs[2]) + Integer.parseInt(lineStrs[3])) / 4);
            }
        }
        for (int i=0; i<persons.length; i++)
            System.out.println(persons[i].score);
    }

}

class Person {
    protected String score;
}
class Student extends Person {
    Student(int avScore){
        this.score = "Student " + avScore;
    }
}
class Teacher extends Person{
    Teacher(int avScore){
        this.score = "Teacher " + avScore;
    }
}