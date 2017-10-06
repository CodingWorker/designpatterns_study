package com.test.design_pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class DetailDemo {
}

//抽象聚合类
abstract class AbstractObjectList{
    protected List<Object> objects=new ArrayList<Object>();
    public AbstractObjectList(List objects){
        this.objects=objects;
    }

    public void addObject(Object obj){
        this.objects.add(obj);
    }

    public void removeObject(Object obj){
        this.objects.remove(obj);
    }

    public List getObjects(){
        return this.objects;
    }

    //声明创建迭代器对象的抽象工厂方法
    abstract public AbstractIterator createIterator();
}

interface AbstractIterator{
    Object next();
    boolean isLast();
    Object previous();
    boolean isFirst();
    boolean hasNext();
}

//商品数据类：具体聚合类
class ProductList extends AbstractObjectList{
    public ProductList(List products){
        super(products);
    }

    public AbstractIterator createIterator(){
        return new ProductIterator(this);
    }

    //商品迭代器：具体迭代器内部类实现
    private class Productor2 implements AbstractIterator{
        private int cursor1;
        private final int cursor2;
        public Productor2(){
            this.cursor1=-1;
            this.cursor2=objects.size()-1;
        }

        public Object next() {
            return objects.get(++cursor1);
        }

        public boolean isLast() {
            return cursor1==cursor2;
        }

        public Object previous() {
            return objects.get(cursor1 - 1);
        }

        public boolean isFirst() {
            return cursor1==0;
        }

        public boolean hasNext() {
            return cursor1<cursor2;
        }
    }
}

class ProductIterator implements AbstractIterator{
    private ProductList productList;
    private List products;
    private int cursor1;
    private final int cursor2;

    public ProductIterator(ProductList list){
        this.productList=list;
        this.products=list.getObjects();
        cursor1=-1;
        cursor2=products.size()-1;
    }

    public Object next() {
        return this.products.get(++cursor1);
    }

    public boolean isLast() {
        return cursor1==cursor2;
    }

    public Object previous() {
        return products.get(cursor1 - 1);
    }

    public boolean isFirst() {
        return cursor1==0;
    }

    public boolean hasNext() {
        return cursor1<cursor2;
    }
}

class Client{
    public static void main(String[] args) {
        List products=new ArrayList();
        products.add("a");
        products.add("b");
        products.add("c");
        products.add("d");
        products.add("e");

        AbstractObjectList list;
        AbstractIterator iterator;

        list=new ProductList(products);
        iterator=list.createIterator();

        System.out.println("遍历");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}