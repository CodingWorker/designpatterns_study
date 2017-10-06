package com.test.design_pattern.component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class SimpleDemo {
}

abstract class Component{
    public abstract void add(Component c);//添加成员
    public abstract void remove(Component c);//删除成员
    public abstract Component getChild(int i);//获取成员
    public abstract void operation();//业务方法
}

class Leaf extends Component{
    @Override
    public void add(Component c) {
        //叶子节点不能添加成员
        //异常处理或者错误提示
    }

    @Override
    public void remove(Component c) {
        //叶子节点不能删除成员
        //异常处理或者错误提示
    }

    @Override
    public Component getChild(int i){
        //叶子节点不能获取成员
        //异常处理或者错误提示
        return null;
    }

    @Override
    public void operation() {
        //叶子构件具体业务方法实现
    }
}

class Composite extends Component{
    private List<Component> list=new ArrayList<Component>();
    @Override
    public void add(Component c) {
        list.add(c);
    }

    @Override
    public void remove(Component c) {
        list.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return list.get(i);
    }

    @Override
    public void operation() {
        //容器构件具体业务方法实现
        //递归调用成员构件的业务方法
        for(Component c:list){
            c.operation();
        }
    }
}