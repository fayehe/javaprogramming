package com.faye.testcase;

/**
 * @Author Faye F F HE
 * @Date 2019/1/1 19:22
 */
public class Finalize {
    public static void main(String[] args) {
        Book book = new Book(1);
        new Book(2);
        System.gc();
        for (e2 e2 : e2.values())
            System.out.print(e2 + ",");
            System.out.print(",");
    }
}

class Book {
    int id;

    Book(int id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        switch (id) {
            case 1 : System.out.print(1); break;
            case 2 : System.out.print(2); break;
            case 3 : System.out.print(3); break;
        }
        System.out.println(" 被释放了");
    }
}

enum e  {
    ONE("this is one"), TWO("haha"), THREE("this is 3");//enum实例必须在前面，后面得加分号
    private String desc ;
    private e(String desc){
        this.desc =desc;
    }
    String getDesc() {
        return this.desc;
    }
    public static void main(String[] args) {
        for(e item : e.values())
            System.out.println(item + ": " + item.getDesc());
        //ONE: this is one
        //TWO: haha
        //THREE: this is 3
    }
}
enum e2{
    spring, summer, august, winter
}

