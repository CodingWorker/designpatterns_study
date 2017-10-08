package com.test.design_pattern.state;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/8
 */
public class SimpleDemo {
}

abstract class State{
    //声明抽象业务方法，不同的具体状态类可以不同的方法实现
    abstract public void handle();
}

class CocreteState extends State{
    public void handle(){
        //方法具体实现代码
    }
}

class Context{
    private State state;//维持一个对抽象状态对象的引用
    private int value;

    //设置状态对象
    public void setState(State state){
        this.state=state;
    }

    public void request(){
        //其他代码
        state.handle();//调用状态对象的业务方法
        //其他代码
    }

    public void changeState(){
        if(value==0){
            this.setState(/*ConcreteStateA*/null);
        }else if(value==1){
            this.setState(/*ConcreteStateB*/null);
        }
        //...
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Other{
    public void changeState(Context ctx){
        //根据环境对象中的属性值进行状态转换
        if(ctx.getValue()==1){
            ctx.setState(/*ConcreteStateB*/null);
        }else if(ctx.getValue()==2){
            ctx.setState(/*ConcreteStateC*/null);
        }
    }
}