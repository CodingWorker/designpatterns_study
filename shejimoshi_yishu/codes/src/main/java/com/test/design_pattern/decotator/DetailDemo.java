package com.test.design_pattern.decotator;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class DetailDemo {
}

//抽象构件
abstract class Component{
    public abstract void display();
}

//具体构件
class Window extends Component{
    public void display(){
        System.out.println("Window display");
    }
}

class TextBox extends Component{
    @Override
    public void display() {
        System.out.println("TextBox display");
    }
}

//具体构件
class ListBox extends Component{
    @Override
    public void display() {
        System.out.println("ListBox display");
    }
}

//抽象装饰器类
class ComponentDecorator extends Component{
    private Component component;
    public ComponentDecorator(Component component){
        this.component=component;
    }

    @Override
    public void display() {
        this.component.display();
    }
}

//具体装饰器类
class ScrollBarDecorator extends ComponentDecorator{
    public ScrollBarDecorator(Component component){
        super(component);
    }

    public void setScrollBar(){
        System.out.println("为构件增加滚动条");
    }

    public void display(){
        this.setScrollBar();
        super.display();
    }
}

//具体装饰器类
class BlackBorderDecorator extends ComponentDecorator{
    public BlackBorderDecorator(Component component){
        super(component);
    }

    public void setBlackBorder(){
        System.out.println("为构件增加黑色边框");
    }

    public void display(){
        this.setBlackBorder();
        super.display();
    }
}

class Client{
    public static void main(String[] args) {
        Component component,componentSB,componentBB;
        component=new Window();
        componentSB=new ScrollBarDecorator(component);
        componentSB.display();

        //扩展多重功能
        componentBB=new BlackBorderDecorator(componentSB);
        componentBB.display();
    }
}


