package com.test.design_pattern.command;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class SimpleDemo {
}

abstract class Command{
    abstract public void execute();
}

class Invoker{
    private Command command;

    //构造注入
    public Invoker(Command command){
        this.command=command;
    }

    //设值注入
    public void setCommand(Command command){
        this.command=command;
    }

    //业务方法，用于调用命令类的execute方法
    public void call(){
        this.command.execute();
    }
}

class Receiver{
    public void action(){
        //具体操作
    }
}

class ConcreteCommand extends Command{
    private Receiver receiver;//维持一个对请求接收者的引用

    public void execute(){
        receiver.action();
    }
}

