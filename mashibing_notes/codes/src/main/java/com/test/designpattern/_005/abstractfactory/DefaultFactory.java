package com.test.designpattern._005.abstractfactory;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class DefaultFactory extends AbstractFactory{
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
