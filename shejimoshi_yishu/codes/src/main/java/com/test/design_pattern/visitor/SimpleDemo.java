package com.test.design_pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class SimpleDemo {
}

abstract class Visitor{
    abstract public void visit(ConcreteElementA elementA);
    abstract public void visit(ConcreteElementB elementB);

    public void visit(ConcreteElementC elementC){
        //元素ConcreteElementC操作代码
    }
}

class ConcteteVisitor extends Visitor{
    @Override
    public void visit(ConcreteElementA elementA) {
        //元素ConcreteElementA操作代码
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        //元素ConcreteElementB操作代码
    }
}

interface Element{
    void accpet(Visitor visitor);
}

class ConcreteElementA implements Element{
    public void accpet(Visitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElementB implements Element{
    public void accpet(Visitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElementC implements Element{
    public void accpet(Visitor visitor) {
        visitor.visit(this);
    }
}

class ObjectStructure{
    private List<Element> elements=new ArrayList<Element>();

    //接受访问者的访问操作
    public void accept(Visitor visitor){
        for (Element element : elements) {
            element.accpet(visitor);
        }
    }

    public void addElement(Element element){
        this.elements.add(element);
    }

    public void removeElement(Element element){
        this.elements.remove(element);
    }
}