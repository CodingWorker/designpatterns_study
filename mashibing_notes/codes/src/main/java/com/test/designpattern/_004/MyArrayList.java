package com.test.designpattern._004;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class MyArrayList<E> implements IMyArrayList<E>{
    private Object[] objects= new Object[16];
    private int currentIndex=0;
    private int size=16;

    private MyIterator<E> myIterator;

    /**
     * @since 1.6
     * @param v
     * @return
     */
    public MyArrayList add(E v){
        if(this.currentIndex==this.size){
            System.out.println(this.currentIndex);
            this.size*=2;
//            this.objects= copy();
            Object[] newObjects=new Object[this.size];
            System.arraycopy(this.objects,0,newObjects,0,this.objects.length);
            this.objects=newObjects;
        }
        System.out.println(this.currentIndex);
        this.objects[this.currentIndex++]=v;
        return this;
    }

    public MyIterator<E> iterator(){
        this.myIterator=new MyArraylistIterator<E>(this);
        return this.myIterator;
    }

    public boolean hasNext(){
        return myIterator.hasNext();
    }

    public E next(){
        return myIterator.next();
    }

    private Object[] copy(){
        Object[] newObject=new Object[this.size];
        for(int i=0;i<this.currentIndex;i++){
            newObject[i]=this.objects[i];
        }

        return newObject;
    }

    private class MyArraylistIterator<E> implements MyIterator<E>{
        private MyArrayList<E> myArrayList;
        private int cursor;

        public MyArraylistIterator(MyArrayList<E> myArrayList){
            this.myArrayList=myArrayList;
        }

        public boolean hasNext() {
            if(cursor>=this.myArrayList.getCurrentIndex())return false;
            return true;
        }

        public E next() {
            return (E)this.myArrayList.getObjects()[cursor++];
        }
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
