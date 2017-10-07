package com.test.design_pattern.template;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class WithHook {
}

abstract class DataViewer{
    //抽象方法：获取数据
    abstract public void getData();

    //具体方法：转换器
    public void convertData(){
        System.out.println("将数据转换为xml格式");
    }

    //抽象方法：显示数据
    abstract public void displayData();

    //钩子方法：判断是否为xml格式的数据
    public boolean isNotXMLData(){
        return true;//默认实现
    }

    //模板方法
    public void process(){
        getData();
        if(!isNotXMLData()){
            convertData();
        }

        displayData();
    }

}

class SubDataViewer extends DataViewer{
    public void getData(){
        System.out.println("从xml文件中读取数据");
    }

    public void displayData(){
        System.out.println("以柱状图显示数据");
    }

    //覆盖钩子方法
    public boolean isNotXMLData(){
        return false;
    }
}

class Client2{
    public static void main(String[] args) {
        DataViewer dv=new SubDataViewer();
        dv.process();
    }
}