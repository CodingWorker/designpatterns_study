package com.test.design_pattern.observer;

import java.io.ObjectStreamConstants;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class SimpleDemo {
}

abstract class Subject{
    //定义一个观察者集合用于存储所有观察者对象
    protected List<Observer> observers=new ArrayList<Observer>();

    //注册方法，用于向观察者集合中增加一个观察者
    public void attach(Observer observer){
        this.observers.add(observer);
    }

    //注销方法，用于从观察者集合中删除一个观察者
    public void detach(Observer observer){
        this.observers.remove(observer);
    }

    //声明抽象通知方法
    abstract public void allNotify();

    public void oneNotify(){
        //空实现
    }
}

class ConcreteSubject extends Subject{
    //实现通知方法
    public void allNotify(){
        for(Observer observer:this.observers){
            observer.update();
        }
    }
}

interface Observer{
    //声明响应方法
    void update();
}

class ConcreteObserver implements Observer{
    public void update() {
        //具体响应代码
    }
}
