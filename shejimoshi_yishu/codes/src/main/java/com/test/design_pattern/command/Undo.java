package com.test.design_pattern.command;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class Undo {
}

class Adder{
    private int num=0;
    public int add(int value){
        num+=value;
        return num;
    }
}

//抽象命令类
abstract class AbstractCommand{
    public abstract int execute(int value);//声明命令执行方法
    public abstract int undo();//声明撤销方法
}

class AddCommand extends AbstractCommand{
    private Adder adder=new Adder();
    private int value;
    public int execute(int value){
        this.value=value;
        return adder.add(this.value);
    }

    public int undo(){
        return adder.add(-this.value);
    }
}

class CalculatorForm{
    private AbstractCommand command;
    public void setCommand(AbstractCommand command){
        this.command=command;
    }

    public void compute(int value){
        int i=this.command.execute(value);
        System.out.println("执行运算，运算结果为："+i);
    }

    public void undo(){
        int i=command.undo();
        System.out.println("执行撤销，运算结果为："+i);
    }
}

class Client2{
    public static void main(String[] args) {
        CalculatorForm cf=new CalculatorForm();
        AbstractCommand command=new AddCommand();
        cf.setCommand(command);

        cf.compute(10);
        cf.compute(5);
        cf.compute(10);
        cf.undo();
    }
}