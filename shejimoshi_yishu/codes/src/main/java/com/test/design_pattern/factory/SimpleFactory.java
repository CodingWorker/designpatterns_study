package com.test.design_pattern.factory;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/28
 */
abstract class Product{
    abstract String price();
}

class ProductA extends Product{
    private String name;
    public ProductA(String name){
        this.name=name;
    }

    @Override
    String price() {
        return "A-price";
    }
}

class ProductB extends Product{
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
    public static Product create(String arg) throws Exception {
        Product product = null;
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
        Product product_1 = SimpleFactory.create("A");
        Product product_2 = SimpleFactory.create("B");

        System.out.println(product_1);
        System.out.println(product_2);
    }
}
