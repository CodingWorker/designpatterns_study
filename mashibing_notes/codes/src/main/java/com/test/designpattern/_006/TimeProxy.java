package com.test.designpattern._006;

/**
 * Created by DaiYan on 2017/9/15.
 */
public class TimeProxy implements Movable{
    private Movable t;
    public TimeProxy(Movable t){
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

    public static void main(String[] args) {
        Movable car=new Car();
        TimeProxy timeProxy=new TimeProxy(car);
        timeProxy.move();
    }
}
