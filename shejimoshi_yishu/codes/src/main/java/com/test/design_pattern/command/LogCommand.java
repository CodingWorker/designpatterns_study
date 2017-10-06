package com.test.design_pattern.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class LogCommand {
}

class ConfigOperator implements Serializable{
    public void insert(String args){
        System.out.println("增加新节点："+args);
    }

    public void modify(String args){
        System.out.println("修改节点："+args);
    }

    public void delete(String args){
        System.out.println("删除节点："+args);
    }
}

//抽象命令类：由于需要将命令对象序列化，所以需要实现serializable接口
abstract class Command2 implements Serializable{
    protected String name;//命令名称
    protected String args;//命令参数
    protected ConfigOperator configOperator;//维持对接收对象的引用

    public Command2(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConfigOperator getConfigOperator() {
        return configOperator;
    }

    abstract public void execute(String args);
    abstract public void execute();
}

//增加命令类：具体命令
class InsertCommand extends Command2{
    public InsertCommand(String name){
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args=args;
        this.configOperator.insert(args);
    }

    @Override
    public void execute() {
        this.configOperator.insert(this.args);
    }
}

//修改命令类：具体命令
class ModifyCommand extends Command2{
    public ModifyCommand(String name){
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args=args;
        this.configOperator.modify(args);
    }

    @Override
    public void execute() {
        this.configOperator.modify(this.args);
    }
}

//配置文件设置窗口类：请求发送者
class ConfigSettingWindow{
    private List<Command2> list=new ArrayList<Command2>();
    private Command2 command;

    //注入具体命令对象
    public void setCommand(Command2 command){
        this.command=command;
    }

    public void call(String args){
        this.command.execute(args);
        this.list.add(command);
    }
}