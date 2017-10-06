package com.test.design_pattern.chain;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class SimpleDemo {
}

abstract class Handler{
    //维持对下家的引用
    protected Handler successor;
    public void setSuccessor(Handler successor){
        this.successor=successor;
    }

    abstract public void handleRequest(String request);
}

class ConcreteHandler extends Handler{
    public void handleRequest(String request){
        if(/*ff*/true) {//条件满足
            //处理请求
        }else{
            this.successor.handleRequest(request);//转发请求
        }
    }
}
