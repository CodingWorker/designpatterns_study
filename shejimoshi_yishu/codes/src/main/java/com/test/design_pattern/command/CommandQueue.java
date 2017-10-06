package com.test.design_pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class CommandQueue {
    //存储命令队列
    private List<Command> commands=new ArrayList<Command>();
    public void addCommand(Command command){
        this.commands.add(command);
    }

    public void removeCommand(Command command){
        this.commands.remove(command);
    }

    //循环调用每个命令对象的execute方法
    public void execute(){
        for(Command command:this.commands){
            command.execute();
        }
    }
}

class Invoker2{
    private CommandQueue commandQueue;

    public Invoker2(CommandQueue commandQueue){
        this.commandQueue=commandQueue;
    }

    public void setCommandQueue(CommandQueue commandQueue){
        this.commandQueue=commandQueue;
    }

    public void call(){
        this.commandQueue.execute();
    }
}
