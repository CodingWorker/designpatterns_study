package com.test.designpattern._005.singleton;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class Singleton2 {
    private static Singleton2 instance=new Singleton2();
    private Singleton2(){}

    public Singleton2 getInstance(){
        return instance;
    }
}
