package com.test.designpattern._004;

/**
 * Created by DaiYan on 2017/9/15.
 */
public class Main {
    public static void main(String[] args) {
//        IMyArrayList myArrayList=new MyArrayList();
        IMyArrayList myArrayList=new MyArrayList2();
        for(int i=0;i<100;i++){
            myArrayList.add(i);
        }

        MyIterator<IMyArrayList> iterator=myArrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
