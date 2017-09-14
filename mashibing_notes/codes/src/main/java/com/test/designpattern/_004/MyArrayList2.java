package com.test.designpattern._004;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class MyArrayList2<E> implements IMyArrayList<E>{
    private Node<E> nodeHead;
    private int size;
    private Node<E> lastNode;

    private MyArrayList2Iterator<E> myArrayList2Iterator;

    public MyArrayList2 add(E v){
        Node node=new Node(v,null);
        if(size==0) {
            this.nodeHead=node;
            this.lastNode=node;
        }else{
            this.lastNode.next=node;
            this.lastNode=node;
        }

        this.size++;
        return this;
    }

    public MyIterator<E> iterator(){
        this.myArrayList2Iterator=new MyArrayList2Iterator<E>(this);
        return this.myArrayList2Iterator;
    }
    public boolean hasNext(){
        return this.myArrayList2Iterator.hasNext();
    }
    public E next(){
        return this.myArrayList2Iterator.next();
    }

    private class Node<E>{
        private E v;
        private Node<E> next;

        public Node(E v,Node<E> n){
            this.v=v;
            this.next=n;
        }

        public E getV() {
            return v;
        }

        public void setV(E v) {
            this.v = v;
        }
    }

    private class MyArrayList2Iterator<E> implements MyIterator<E>{
        private MyArrayList2<E> myArrayList2;
        private Node<E> currentNode;

        public MyArrayList2Iterator(MyArrayList2<E> myArrayList2){
            this.myArrayList2=myArrayList2;
            this.currentNode=myArrayList2.nodeHead;
        }

        public boolean hasNext() {
            return this.currentNode.next!=null;
        }

        public E next() {
            Node<E> thatNode= this.currentNode.next;
            this.currentNode=this.currentNode.next;
            return thatNode.getV();
        }
    }
}
