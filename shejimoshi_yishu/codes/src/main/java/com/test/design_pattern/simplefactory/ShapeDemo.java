package com.test.design_pattern.simplefactory;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/29
 */
public class ShapeDemo {
}

abstract class AbstractShape {
    abstract void draw();
    abstract void erase();

    public static AbstractShape create(ShapeEnum shapeEnum)throws UnSupportedShapeException{
        AbstractShape shape=null;
        switch(shapeEnum){
            case Tiangle:
                shape=new Triangle();
                break;
            case Rectangle:
                shape=new Rectangle();
                break;
            case Circular:
                shape=new Circular();
                break;
            default:
                throw new UnSupportedShapeException();
        }

        return shape;
    }
}

class Triangle extends AbstractShape {
    @Override
    void draw() {
        System.out.println("draw a triangle");
    }

    @Override
    void erase() {
        System.out.println("erase a triangle");
    }
}

class Rectangle extends AbstractShape {
    @Override
    void draw() {
        System.out.println("draw a rectangle");
    }

    @Override
    void erase() {
        System.out.println("erase a rectangle");
    }
}

class Circular extends AbstractShape {
    @Override
    void draw() {
        System.out.println("draw a circular");
    }

    @Override
    void erase() {
        System.out.println("erase a circular");
    }
}

class UnSupportedShapeException extends Exception{
    public UnSupportedShapeException(){}
    public UnSupportedShapeException(String msg){super(msg);}
}

enum ShapeEnum{
    Tiangle(1),
    Rectangle(2),
    Circular(3);

    private int id;
    ShapeEnum(int id){this.id=id;}

    public int getId() {
        return id;
    }
}

class ShapeTest{
    public static void main(String[] args) throws UnSupportedShapeException{
        AbstractShape shape1= AbstractShape.create(ShapeEnum.Rectangle);
        AbstractShape shape2= AbstractShape.create(ShapeEnum.Circular);

        shape1.draw();
        shape2.draw();
    }
}
