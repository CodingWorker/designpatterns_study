package com.test.design_pattern.command;

import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;

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

//功能键类，请求发送者
class FunctionButton{
    private String name;
    private Command command;//维持一个抽象命令对象的引用

    public FunctionButton(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    //为功能键注入命令对象
    public void setCommand(Command command){
        this.command=command;
    }

    //发送请求方法
    public void onClick(){
        System.out.println("点击功能键：");
        this.command.execute();
    }
}

class FBSettingWindow{
    private String title;

    //存储所有的功能键
    private List<FunctionButton> list=new ArrayList<FunctionButton>();

    public FBSettingWindow(String title){
        this.title=title;
    }

    public void addFunctionButtion(FunctionButton fb){
        this.list.add(fb);
    }

    public void removeFunctionButtion(FunctionButton fb){
        this.list.remove(fb);
    }

    //显示窗口及功能键
    public void display(){
        System.out.println("显示窗口: "+this.title);
        System.out.println("显示功能键：");
        for(FunctionButton fb:list){
            System.out.println(fb.getName());
        }

        System.out.println("-----------------------------------");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class HelpHandler{
    public void display(){
        System.out.println("显示帮助文档");
    }
}

class WindowHandler{
    public void minimize(){
        System.out.println("将窗口最小化至托盘");
    }
}

//帮助命令类
class HelpCommand extends Command{
    private HelpHandler helpHandler;

    public HelpCommand(){
        this.helpHandler=new HelpHandler();
    }

    public void execute(){
        this.helpHandler.display();
    }
}

class MinimizeCommand extends Command{
    private WindowHandler windowHandler;
    public MinimizeCommand(){
        this.windowHandler=new WindowHandler();
    }

    @Override
    public void execute() {
        this.windowHandler.minimize();
    }
}

class Client{
    public static void main(String[] args) {
        FBSettingWindow fbsw=new FBSettingWindow("功能键设置");

        FunctionButton fb1,fb2;
        fb1=new FunctionButton("功能键1");
        fb2=new FunctionButton("功能键2");


        Command command1,command2;
        command1=new HelpCommand();
        command2=new MinimizeCommand();

        //将命令对象注入到功能键
        fb1.setCommand(command1);
        fb2.setCommand(command2);

        fbsw.addFunctionButtion(fb1);
        fbsw.addFunctionButtion(fb2);
        fbsw.display();

        //调用功能键的业务方法
        fb1.onClick();
        fb2.onClick();
    }
}




