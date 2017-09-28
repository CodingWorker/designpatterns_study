package com.test.design_pattern.singleton;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/28
 */
public class BetterSingleton {

    private BetterSingleton(){}

    public static BetterSingleton getInstance(){
        return HolderClass.instance;
    }

    private static class HolderClass{
        private static final BetterSingleton instance=new BetterSingleton();
    }
}
