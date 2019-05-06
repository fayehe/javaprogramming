package com.faye.testcase;

/**
 * @Author Faye F F HE
 * @Date 2019/1/4 22:40
 */
public class Test {

    public static void main(String args[]){
//        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
//                'i', 'n', 'a', 't', 'e', 'd'};
//        char[] copyTo = new char[7];
//        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
//        System.out.println(new String(copyTo));
        int count = 0;
        for (int i=0; i<100000; i++){
            double a=Math.random(), b=Math.random(), c=Math.random(),d;
            if (a <= b){
                if (b<=c){
                    d = b;
                }else {
                    if (a<=c) d = c;
                    else d = a;
                }
            }else {
                if(b>=c) d = b;
                else {
                    if(a>=c) d = c;
                    else d = a;
                }
            }
            if (d<0.1 || d>0.9) count++;
        }
        System.out.println(count);
    }

}
