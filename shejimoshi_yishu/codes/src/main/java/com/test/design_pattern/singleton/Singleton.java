package com.test.design_pattern.singleton;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/28
 */

/**
 * 设计步骤：
 *      1. 私有化构造器
 *      2. 私有的该类的静态成员变量
 *      3. 公共的外部访问该成员变量的静态方法
 *
 *  两种构造方式：
 *      1. 懒汉式
 *      2. 饿汉式
 */

/**
 * 懒汉式
 */
public class Singleton {
    //volatile关键字避免指令重排序
    private volatile static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(null==instance){
            synchronized (Singleton.class){
                if(null==instance){
                    instance=new Singleton();
                }
            }
        }

        return instance;
    }
}

/**
 * 饿汉式
 */
class Singleton2{
    private static final Singleton2 instance=new Singleton2();
    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }
}