package com.test.designpattern._005.abstractfactory;

/**
 * Created by DaiYan on 2017/9/14.
 */
public abstract class AbstractFactory {
    abstract public Vehicle createVehicle();
    abstract public Food createFood();
    abstract public Weapon createWeapon();
}
