package com.test.design_pattern.decotator;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class SimpleDemo {
}

interface Component1{
    void operation();
}

class Decorator implements Component1{
    private Component1 component;//维持一个对抽象构件对象的引用
    public Decorator(Component1 component){
        this.component=component;
    }

    public void operation() {//调用原有的业务方法
        component.operation();
    }
}

class ConcreteDecoratro extends Decorator{
    public ConcreteDecoratro(Component1 component){
        super(component);
    }

    @Override
    public void operation(){
        super.operation();//调用原有业务方法
        this.addBehavior();
    }

    public void addBehavior(){
        //增强业务逻辑
    }
}
