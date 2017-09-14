package com.test.designpattern._005.singleton;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){}

    private Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }

        return instance;
    }
}
