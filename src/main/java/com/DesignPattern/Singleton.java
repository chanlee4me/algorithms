package com.DesignPattern;

import java.util.ArrayList;

public class Singleton {
    private static Singleton  instance = new Singleton();
    private Singleton(){}
    /**
     * 为什么要声明为 static：
     * 如果不是 static，必须先有一个Singleton对象才能调用 getInstance()
     * 但构造函数是private的，外部无法new Singleton()，这就成了“死循环”。
     * @return
     */
    public static Singleton getInstance(){
        return instance;
    }
    public void test(){
        System.out.println("test");
    }
}
