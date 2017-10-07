package com.test.design_pattern.strategy;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class SimpleDemo {
}

abstract class AbstractStrategy{
    abstract public void algorithm();//声明抽象算法
}

class ConcreteStrategyA extends AbstractStrategy{
    @Override
    public void algorithm() {
        //算法A
    }
}

class Context{
    private AbstractStrategy strategy;//维持一个对抽象策略类的引用
    public void setStrategy(AbstractStrategy strategy){
        this.strategy=strategy;
    }

    //调用策略类的算法
    public void algrithm(){
        this.strategy.algorithm();
    }
}

class Client{
    public static void main(String[] args) {
        Context context=new Context();
        AbstractStrategy strategy=new ConcreteStrategyA();
        context.setStrategy(strategy);
        context.algrithm();
    }
}
