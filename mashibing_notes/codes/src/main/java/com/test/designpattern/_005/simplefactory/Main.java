package com.test.designpattern._005.simplefactory;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class Main {
    public static void main(String[] args){
        VehicleFactory factory=new CarFacory();
        Movable movable=factory.create();
        movable.run();
    }
}
