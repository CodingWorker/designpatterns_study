package com.test.design_pattern.mediator;

import javax.print.attribute.standard.Media;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/8
 */
public class SimpleDemo {
}

abstract class Mediator{
    protected List<Colleague> colleagues;//维持同事对象引用的集合

    //注册方法
    public void register(Colleague colleague){
        this.colleagues.add(colleague);
    }

    //声明业务方法
    abstract public void operation();
}

class ConcreteMediator extends Mediator{
    @Override
    public void operation() {//实现业务封装，封装同事之间的调用

    }
}

abstract class Colleague{
    protected Mediator mediator;//维持一个抽象中介者的引用

    public Colleague(Mediator mediator){
        this.mediator=mediator;
    }

    abstract public void method1();//声明自身方法，处理自己的行为

    //定义依赖方法，与中介者进行通信
    public void method2(){
        mediator.operation();
    }
}

class ConcreteColleague extends Colleague{
    public ConcreteColleague(Mediator mediator){
        super(mediator);
    }

    @Override
    public void method1() {
        //实现自身方法
    }
}
