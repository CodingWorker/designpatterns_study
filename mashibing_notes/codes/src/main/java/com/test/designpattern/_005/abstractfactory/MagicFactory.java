package com.test.designpattern._005.abstractfactory;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class MagicFactory extends AbstractFactory {
    @Override
    public Vehicle createVehicle() {
        return new Plane();
    }

    @Override
    public Food createFood() {
        return new Mushroom();
    }

    @Override
    public Weapon createWeapon() {
        return new Stick();
    }
}
