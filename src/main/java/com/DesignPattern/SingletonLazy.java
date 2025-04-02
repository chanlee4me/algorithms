package com.DesignPattern;

public class SingletonLazy {
    private static SingletonLazy instance = null;
    private SingletonLazy(){}

    /**
     * 为什么要声明为 static：
     * 如果不是 static，必须先有一个Singleton对象才能调用 getInstance()
     * 但构造函数是private的，外部无法new Singleton()，这就成了“死循环”。
     * @return
     */
    public static SingletonLazy getInstance(){
        //还未实例化
        if(instance == null){
            synchronized (SingletonLazy.class){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    public void test(){
        System.out.println("test");
    }
}
