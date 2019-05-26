package com.faye.dsa;

/**
 * @Author Faye F F HE
 * @Date 2019/5/7 8:37
 */
public class searching {
    public static void main(String[] args) {
        int[] arr = {1,3,5,8,23,45};
        System.out.println(binSearch(arr, 3));
        System.out.println(7/2);
    }

    //

    /**
     * 二分查找：O(logn)
     *
     * @param arr：有序向量
     * @param e：要查找的数
     * @return ：不大于arr且秩最大的元素
     */
    public static int binSearch(int[] arr, int e){
        int mi, lo = 0, hi = arr.length;
        while(lo < hi){ // 版本C，严格符合接口语义约定
            mi = (lo + hi) >> 1;
            if (e < arr[mi]){
                hi = mi;
            }else{
                lo = mi + 1;
            }
        }
        return arr[--lo] == e ? lo : -1;
    }
}
