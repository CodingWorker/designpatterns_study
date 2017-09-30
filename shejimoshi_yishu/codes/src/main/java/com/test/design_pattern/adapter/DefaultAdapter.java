package com.test.design_pattern.adapter;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class DefaultAdapter {
}
interface IOperation{
    void doA();
    void doB();
    void doC();
    void doD();
    void doE();
    void doF();
    void doG();
}

abstract class AbsOperation implements IOperation{
    public void doA() {

    }

    public void doB() {

    }

    public void doC() {

    }

    public void doD() {

    }

    public void doE() {

    }

    public void doF() {

    }

    public void doG() {

    }
}

class OperationABC extends AbsOperation{
    @Override
    public void doA(){
        //do some stuff
    }

    @Override
    public void doB(){
        //do some stuff
    }

    @Override
    public void doC(){
        //do some stuff
    }
}