package com.test.designpattern._005.simplefactory;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class CarFacory extends VehicleFactory {
    public Movable create(){
        return new Car();
    }
}
