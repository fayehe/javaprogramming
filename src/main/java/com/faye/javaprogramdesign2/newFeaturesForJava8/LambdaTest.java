package com.faye.javaprogramdesign2.newFeaturesForJava8;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Faye F F HE
 * @Date 2019/6/13 22:03
 */
public class LambdaTest {
    public static void main(String[] args) {
        anonymousClass();
        System.out.println("====================================");
        forEachList();
        System.out.println("====================================");
        functionalProgramming();
    }


    /**
     * 例1、用() -> {}代码块替代了整个匿名类。
     */
    public static void anonymousClass(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        new Thread(() -> System.out.println("after java8,  Lambda expression")).start();
    }

    /**
     * 例2、使用lambda表达式对列表进行迭代
     */
    public static void forEachList(){
        Integer[] array = {5, 8, 10, 9, 33};
        Arrays.sort(array, (x, y) -> x<=y? -1 : 1);
        //list.forEach((a) -> System.out.println(a));
        Arrays.asList(array).forEach(System.out::println); // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
    }

    /**
     * 例3、使用lambda进行函数式编程
     */
    public static void functionalProgramming(){
        // 为每个订单加上12%的税
        // 老方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total1 : " + total);

        // 新方法：
        double bill = costBeforeTax.stream().map(cost -> 1.12*cost).reduce((a, b) -> a+b).get();
        System.out.println("Total2 : " + bill);
    }

}
