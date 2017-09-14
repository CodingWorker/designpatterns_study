package com.test.designpattern._004;

/**
 * Created by DaiYan on 2017/9/15.
 */
public interface IMyArrayList<T> extends MyIterator<T>{
    IMyArrayList<T> add(T o);
    MyIterator<T> iterator();
}
