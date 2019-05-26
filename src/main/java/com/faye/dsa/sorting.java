package com.faye.dsa;

import java.util.Arrays;

/**
 * @Author Faye F F HE
 * @Date 2019/5/7 22:02
 */
public class sorting {

    public static void main(String[] args) {
        int[] arr = {1, 34, 2, 45, 47, 4, 98, 11, 2, 118};
        bubbleSort(arr);
        System.out.println("起泡排序：" + Arrays.toString(arr));

        int[] arr2 = {1, 34, 2, 45, 47, 4, 98, 11, 2, 118};
        selectionSort(arr2);
        System.out.println("选择排序：" + Arrays.toString(arr2));

        int[] arr3 = {1, 34, 2, 45, 47, 4, 98, 11, 2, 118};
        mergeSort(arr3, 0, arr2.length-1);
        System.out.println("归并排序：" + Arrays.toString(arr3));

        int[] arr4 = {1, 34, 2, 45, 47, 4, 98, 11, 2, 118};
        insertSort(arr4);
        System.out.println("插入排序：" + Arrays.toString(arr4));

        int[] arr5 = {1, 34, 2, 45, 47, 4, 98, 11, 2, 118};
        heapSort(arr5);
        System.out.println("堆排序的：" + Arrays.toString(arr5));

        int[] arr6 = {1, 34, 2, 45, 47, 4, 98, 11, 2, 118};
        quickSort(arr6, 0, arr6.length-1);
        System.out.println("快速排序：" + Arrays.toString(arr6));
    }

    /**
     * 起泡排序：从左向右，比较，交换出最大的放在后面
     * 复杂度：O(n^2)
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j+1]) swap(arr, j);
            }
        }
    }

    /**
     * 选择排序：从第一个位置开始比较，找出最小的，和第一个位置互换，开始下一轮。
     * 复杂度：O(n^2)

     与冒泡排序区别：
         （1）冒泡排序是比较相邻位置的两个数，而选择排序是按顺序比较，找最大值或者最小值；
         （2）冒泡排序每一轮比较后，位置不对都需要换位置，选择排序每一轮比较都只需要换一次位置；
         （3）冒泡排序是通过数去找位置，选择排序是给定位置去找数；

     冒泡排序优缺点：
        优点:比较简单，空间复杂度较低，是稳定的；
        缺点:时间复杂度太高，效率慢；

     选择排序优缺点：
        优点：一轮比较最多要换一次位置；
        缺点：效率慢，不稳定（举个例子5，8，5，2，9 我们知道第一遍选择第一个元素5会和2交换，那么原序列中2个5的相对位置前后顺序就破坏了）。

     * @param arr
     */
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int min = i; //每轮比较最小值的秩
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]) min = j;
            }
            if (min != i) swap(arr, min, i);
        }
    }

    /**
     * 插入排序：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。类似于整扑克牌。
     * 复杂度：O(n^2)
     * 适于List实现， 而非数组实现
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i];

            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }
    }

    public static void swap(int[] arr, int j){
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *归并排序：两个有序序列，合并为一个有序序列
     *  优点：实现最坏情况下最优O(nlogn)性能的第一个排序算法；不需随机读写，完全顺序访问——尤其适用于列表、磁带等；可扩展性极佳，易于优化
        缺点：需要等规模辅助空间；即便输入完全有序，仍需O(nlogn)

     * @param arr
     * @param low
     * @param high
     */
    public static void mergeSort(int[] arr, int low, int high){
        if (high-low <= 1) return;

        int mid = (low + high) >> 1;
        mergeSort(arr, low, mid);
        mergeSort(arr,mid+1, high);
        merge(arr, low, mid, high);//左右归并
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        // 把较小的数先移到新数组中
        while(i <= mid && j <= high){
            temp[k++] = arr[i]<arr[j] ? arr[i++] : arr[j++];
        }
        // 把左边剩余的数移入数组
        while(i <= mid) temp[k++] = arr[i++];

        // 把右边边剩余的数移入数组
        while(j <= high) temp[k++] = arr[j++];

        // 把新数组中的数覆盖原数组
        System.arraycopy(temp, 0, arr, low, temp.length);

    }

    /**
     *堆排序：构造大顶堆，自右向左，自下而上
     * 复杂度：O(nlogn)
     *
     * @param array
     */
    public static void heapSort(int[] array){
        buildMaxHeap(array); //初始建堆，array[0]为第一趟值最大的元素
        for(int i=array.length-1; i>0; i--){
            swap(array, 0, i); //将堆顶元素和堆底元素交换，即得到当前最大元素正确的排序位置
            adjustDownToUp(array, 0, i);  //整理，将剩余的元素整理成堆
        }
    }
    //构建大根堆：将array看成完全二叉树的顺序存储结构  O(nlogn)
    private static void buildMaxHeap(int[] array){
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for(int i=array.length/2-1; i>=0; i--){
            adjustDownToUp(array, i, array.length);
        }
    }
    //下滤 O(logn)
    private static void adjustDownToUp(int[] array, int k, int length){
        int temp = array[k];
        for(int i=2*k+1; i<length; i=2*i+1){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if(i+1<length && array[i]<array[i+1]){  //取节点较大的子节点的下标
                i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if(temp>=array[i]){  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            }else{   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的节点的值放入最终位置
    }

    /**
     * 快速排序：交替地向内移动lo,hi，逐个检查当前元素，若更小/大，则转移归入L/G；当lo=hi时，将候选者嵌入L、G之间，它即是轴点
     *     mergesort（归并排序）的计算量和难点在于合，而quicksort在于分（找到轴点）
     *
     *   最好情况：每次划分都接近平均，轴点总是中央；O(nlogn)
         最坏情况：每次划分都极不均衡；O(n^2)
         平均性能：O(nlogn)；T(n) = ...复杂的推导... = 1.39nlogn = O(logn)
          不稳定排序
     * @param arr
     * @param _left
     * @param _right
     */
    public static void quickSort(int arr[],int _left,int _right){
        int left = _left;
        int right = _right;
        int temp = 0;
        if(left <= right){   //待排序的元素至少有两个的情况
            temp = arr[left];  //待排序的第一个元素作为基准元素
            while(left != right){   //从左右两边交替扫描，直到left = right

                while(right > left && arr[right] >= temp)
                    right --;        //从右往左扫描，找到第一个比基准元素小的元素
                arr[left] = arr[right];  //找到这种元素arr[right]后与arr[left]交换

                while(left < right && arr[left] <= temp)
                    left ++;         //从左往右扫描，找到第一个比基准元素大的元素
                arr[right] = arr[left];  //找到这种元素arr[left]后，与arr[right]交换

            }
            arr[right] = temp;    //基准元素归位
            quickSort(arr,_left,left-1);  //对基准元素左边的元素进行递归排序
            quickSort(arr, right+1,_right);  //对基准元素右边的进行递归排序
        }
    }

}
