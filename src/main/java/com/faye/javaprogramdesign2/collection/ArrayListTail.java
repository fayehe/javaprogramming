package com.faye.javaprogramdesign2.collection;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Faye F F HE
 * @Date 2019/2/24 22:08
 *
 * 给定一个线性表，如果你不知道什么是线性表，可以去看看数据结构。

    当然，简单的说就是给一组数。

    一共有如下5种操作：

    1 index：查询第index位置上的数，如果index非法，则输出-1

    2 value：将value插入到表的尾部

    3 n v1 v2 ... vn:将v1到vn的n个数一次插入到表的尾部

    4: 删除表尾的一个数，如果表是空的，则什么都不做

    5 n: 删除表尾的n个数，如果表中没有n个数，则将表中的数全部删除

    对每一个1指令，打印输出查询到的数值。

    初始时，表是空的。

    特别的，index从1开始，也就是说表首元素是第1个元素，而不是第0个。

    本题出现的所有数据均是正的int类型。



    本题的输入功能由系统完成，无需学员编写。

    因此本题不提供输入输出样例，学员按照题目描述进行处理输出即可。


 */
//表示指令的对象
class Cmd{
    int cmd;				//只能取值1~5
    int nOrIndexOrValue;	//cmd为1时，该域表示index
                            //cmd为2时，该域表示value
                            //cmd为3时，该域表示n
                            //cmd为4时，该域忽略
                            //cmd为5时，该域表示n
    Integer [] params;		//cmd为3时，该域含n个int
}

public class ArrayListTail {
    public static void main(String[] args) {
        Cmd [] commands = getCmd();//获取指令序列

        //学员需要自行定义数据编写代码完成题目指定的任务
        /***being your code here****/
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=0; i<commands.length; i++){
            switch (commands[i].cmd){
                case 1: {
                    if (commands[i].nOrIndexOrValue > list.size()) System.out.println(-1);
                    else System.out.println(list.get(commands[i].nOrIndexOrValue-1));
                    break;
                }
                case 2:{
                    list.add(commands[i].nOrIndexOrValue);
                    break;
                }
                case 3:{
                    for (int j=0; j<commands[i].params.length; j++) list.add(commands[i].params[j]);
//                    list.addAll(Arrays.asList(commands[i].params));
                    break;
                }
                case 4:{
                    if (list.size() > 0) list.remove(list.size() - 1);
                    break;
                }
                case 5:{
                    for (int j=0; i<commands[i].nOrIndexOrValue; j++) {
                        if (list.size() > 0)
                        list.remove(list.size() - 1);
                    }
                    break;
                }
            }
        }
        /***end your code****/
    }

    //生成指令序列，学员可以无视
    private static Cmd[] getCmd(){
        Scanner cin = new Scanner(System.in);
        A = cin.nextInt();
        B = cin.nextInt();
        M = cin.nextInt();
        X = cin.nextInt();
        cin.close();

        int n = get();
        Cmd [] ret = new Cmd [n];
        ret[0] = new Cmd();
        ret[0].cmd = 3;
        ret[0].nOrIndexOrValue = get();
        ret[0].params = new Integer [ret[0].nOrIndexOrValue];
        for(int i=0;i!=ret[0].nOrIndexOrValue;++i) ret[0].params[i] = get();

        for(int i=1;i!=n;++i) {
            Cmd cmd = new Cmd();
            cmd.cmd = get()%5+1;
            switch(cmd.cmd) {
                case 1:
                case 2:cmd.nOrIndexOrValue=get();break;
                case 3:cmd.nOrIndexOrValue=get();cmd.params=new Integer[cmd.nOrIndexOrValue];for(int j=0;j!=cmd.nOrIndexOrValue;++j)cmd.params[j]=get();break;
                case 4:break;
                case 5:cmd.nOrIndexOrValue=get();break;
            }
            ret[i] = cmd;
        }
        return ret;
    }

    //学员可以无视
    private static int A,B,M,X;
    private static int get() {
        X = (A*X+B) % M;
        return X;
    }
}



