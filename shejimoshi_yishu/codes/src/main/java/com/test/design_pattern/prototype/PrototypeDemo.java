package com.test.design_pattern.prototype;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class PrototypeDemo {
}

class ConcretePrototype implements Cloneable{
    //do other stuff

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj=super.clone();

        return (ConcretePrototype)obj;
    }
}
