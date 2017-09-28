package com.test.design_pattern.simplefactory;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/28
 */
abstract class AbstractProduct {
    abstract String price();

    /**
     * 为了简化，也可以将工厂和抽象类合并
     * @param arg
     * @return
     * @throws Exception
     */
    public static AbstractProduct create(String arg) throws Exception {
        AbstractProduct product = null;
        if (arg.equals("A")) {
            product = new ProductA("A");
        } else if (arg.equals("B")) {
            product = new ProductB("B");
        } else {
            throw new Exception("illegal arg");
        }

        return product;
    }
}

class ProductA extends AbstractProduct {
    private String name;
    public ProductA(String name){
        this.name=name;
    }

    @Override
    String price() {
        return "A-price";
    }
}

class ProductB extends AbstractProduct {
    private String name;
    public ProductB(String name){
        this.name=name;
    }

    @Override
    String price() {
        return "B-price";
    }
}

public class SimpleFactory {
    public static AbstractProduct create(String arg) throws Exception {
        AbstractProduct product = null;
        if (arg.equals("A")) {
            product = new ProductA("A");
        } else if (arg.equals("B")) {
            product = new ProductB("B");
        } else {
            throw new Exception("illegal arg");
        }

        return product;
    }

    public static void main(String[] args) throws Exception {
        AbstractProduct product_1 = SimpleFactory.create("A");
        AbstractProduct product_2 = SimpleFactory.create("B");

        System.out.println(product_1);
        System.out.println(product_2);
    }
}
