package com.test.design_pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class SimpleDemo {
}

class Flyweight{
    //内部状态intrinsicState作为成员变量，同一个享元对象其内部状态是一致的
    private String intrinsicState;

    public Flyweight(String intrinsicState){
        this.intrinsicState=intrinsicState;
    }

    //外部状态extrinsicState在使用时由外部设置，不保存在享元对象中，即使是
    //同一个对象，在每次调用时可以传入不同外部状态
    public void operation(String extrinsicState){
        //...
    }
}

class FlyweightFactory{
    private Map<String,Flyweight> flyweights=new HashMap<String, Flyweight>();

    public Flyweight getFlyweight(String key){
        if(!this.flyweights.containsKey(key)){
            this.flyweights.put(key,new Flyweight(""));
        }

        return this.flyweights.get(key);
    }
}
