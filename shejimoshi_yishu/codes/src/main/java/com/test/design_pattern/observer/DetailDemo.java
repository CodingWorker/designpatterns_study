package com.test.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class DetailDemo {
}

//抽象观察者类
interface Observer2{
    String getName();
    void setName(String name);
    void help();//声明支援盟友方法
    void beAttacked(AllyControlCenter acc);//声明遭受攻击方法
}

//战队成员类：具体观察者类
class Player implements Observer2{
    private String name;

    public Player(String name){
        this.name=name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void help() {
        System.out.println("坚持住，"+this.name+" 来救济");
    }

    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name+" 被袭击");
        acc.notifyObserver(this.name);
    }
}

//战队控制中心类：目标类
abstract class AllyControlCenter{
    protected String allyName;
    protected List<Observer2> observers=new ArrayList<Observer2>();

    public void setAllyName(String name){
        this.allyName=name;
    }

    public String getAllyName(){
        return this.allyName;
    }

    //注册方法
    public void join(Observer2 observer){
        System.out.println(observer.getName()+" 加入战队");
        this.observers.add(observer);
    }

    //注销方法
    public void quit(Observer2 observer){
        System.out.println(observer.getName()+" 退出战队");
        this.observers.remove(observer);
    }

    //声明抽象通知方法
    abstract public void notifyObserver(String name);
}

//具体战队控制中心类：具体目标类
class ConcreteAllyControlCenter extends AllyControlCenter {
    public ConcreteAllyControlCenter(String allayName) {
        System.out.println(allayName + " 战队组建成功");
        System.out.println("-------------------");
        this.allyName = allayName;
    }

    @Override
    public void notifyObserver(String name) {
        System.out.println(this.allyName+" 战队紧急通知：盟友 "+name+" 遭受袭击");
        for (Observer2 observer : this.observers) {
            if(!name.equalsIgnoreCase(observer.getName()))//排除自己
                observer.help();
        }
    }
}

class Client{
    public static void main(String[] args) {
        AllyControlCenter acc=new ConcreteAllyControlCenter("A队");
        Observer2 player1,player2,player3,player4;
        player1=new Player("a1");
        acc.join(player1);
        player2=new Player("a2");
        acc.join(player2);
        player3=new Player("a3");
        acc.join(player3);
        player4=new Player("a4");
        acc.join(player4);

        player1.beAttacked(acc);
    }
}