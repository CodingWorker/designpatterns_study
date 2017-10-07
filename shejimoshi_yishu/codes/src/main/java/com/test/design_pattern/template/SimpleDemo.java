package com.test.design_pattern.template;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class SimpleDemo {
}

abstract class AbstractClass{
    //模板方法
    public void templateMethod(){
        primitiveOpt1();
        primitiveOpt2();
        primitiveOpt3();
    }

    //基本方法：具体方法
    public void primitiveOpt1(){
        //实现代码
    }

    //基本方法：抽象方法
    abstract public void primitiveOpt2();

    //钩子方法
    public void primitiveOpt3(){

    }
}

//具体子类
class ConcreteClass extends AbstractClass{
    @Override
    public void primitiveOpt2() {
        //实现代码
    }

    @Override
    public void primitiveOpt3() {
        //实现代码
    }
}
