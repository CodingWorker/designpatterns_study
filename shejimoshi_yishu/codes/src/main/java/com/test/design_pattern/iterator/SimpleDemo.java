package com.test.design_pattern.iterator;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class SimpleDemo {
}

interface Iterator{
    Object first();
    Object next();
    boolean hasNext();
    Object currentItem();
}

interface Aggregate{
    Iterator createIterator();
}

class ConcreteAggregate implements Aggregate{
    public Iterator createIterator(){
        return new ConcreteIterator(this);
    }
}

class ConcreteIterator implements Iterator{
    private ConcreteAggregate object;
    private int cursor;

    public ConcreteIterator(ConcreteAggregate object){
        this.object=object;
    }

    public Object first() {
        return null;
    }

    public Object next() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public Object currentItem() {
        return null;
    }
}