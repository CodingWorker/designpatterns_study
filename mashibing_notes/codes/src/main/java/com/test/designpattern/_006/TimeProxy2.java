package com.test.designpattern._006;

/**
 * Created by DaiYan on 2017/9/15.
 */
public class TimeProxy2 implements Movable{
    private Movable t;
    public TimeProxy2(Movable t){
        super();
        this.t=t;
    }

    public void move(){
        long start=System.currentTimeMillis();
        System.out.println("startTime:"+start);
        t.move();
        long end=System.currentTimeMillis();
        System.out.println("endTime:"+end);
        System.out.println("timeSpan:"+(end-start));
    }
}