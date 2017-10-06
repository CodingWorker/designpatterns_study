package com.test.design_pattern.component;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class NoTransport {
}

abstract class AbsrtractFile{
    public void add(AbstractFile file){
        System.out.println("对不起，不支持该方法");
    }

    public void remove(AbstractFile file){
        System.out.println("对不起，不支持该方法");
    }

    public AbstractFile getChild(int i){
        System.out.println("对不起，不支持该方法");
        return null;
    }

    abstract public void killVirus();
}

abstract class AbstractFile2{
    abstract public void killVirus();
}