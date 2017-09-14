package com.test.designpattern._005.abstractfactory;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) {
//        AbstractFactory factory=new DefaultFactory();
        AbstractFactory factory=new MagicFactory();

        Vehicle vehicle=factory.createVehicle();
        vehicle.run();
        Food food=factory.createFood();
        food.taste();
        Weapon weapon=factory.createWeapon();
        weapon.shoot();
    }
}
