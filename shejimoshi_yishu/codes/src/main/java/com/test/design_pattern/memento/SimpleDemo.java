package com.test.design_pattern.memento;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/8
 */
public class SimpleDemo {
}

class Originator{
    private String state;

    //创建一个备忘录对象
    public Memento createMemento(){
        return new Memento(this);
    }

    //根据备忘录对象恢复原发器状态
    public void restoreMemento(Memento m){
        state=m.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

//默认包内可见
class Memento{
    private String state;
    public Memento(Originator originator){
        state=originator.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Caretaker{
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
