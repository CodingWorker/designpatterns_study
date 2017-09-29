package com.test.design_pattern.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
interface OfficialDoc{
    OfficialDoc clone();
    void display();
}

class ADoc implements OfficialDoc{
    public OfficialDoc clone() {
        return new ADoc();
    }

    public void display() {
        System.out.println("ADoc display");
    }
}

class BDoc implements OfficialDoc{
    public OfficialDoc clone() {
        return new BDoc();
    }

    public void display() {
        System.out.println("BDoc display");
    }
}

public class PrototypeManager {
    private Map<String,OfficialDoc> prototypes;
    public PrototypeManager(){
        this.prototypes=new HashMap<String, OfficialDoc>();
    }

    public void addPrototype(String key,OfficialDoc doc){
        this.prototypes.put(key,doc);
    }

    public OfficialDoc getPrototype(String key){
        return this.prototypes.get(key);
    }
}

class Client{
    public static void main(String[] args) {
        PrototypeManager manager=new PrototypeManager();
        manager.addPrototype("a",new ADoc());
        manager.addPrototype("b",new BDoc());

        OfficialDoc doc=manager.getPrototype("a");
    }
}

