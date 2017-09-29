package com.test.design_pattern.abstractfactory;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/29
 */
public class MyFactory {
}

interface Button{
    void display();
}

class SpringButton implements Button{
    public void display() {
        System.out.println("spring button");
    }
}

class SummerButton implements Button{
    public void display() {
        System.out.println("summer button");
    }
}

interface TextField{
    void display();
}

class SpringTextField implements TextField{
    public void display() {
        System.out.println("spring text field");
    }
}

class SummerTextField implements TextField{
    public void display() {
        System.out.println("summer text field");
    }
}

interface ComboBox{
    void display();
}

class SpringComboBox implements ComboBox{
    public void display() {
        System.out.println("spring combo box");
    }
}

class SummerComboBox implements ComboBox{
    public void display() {
        System.out.println("summer combo box");
    }
}

interface SkinFactory{
    Button createButton();
    TextField createTextField();
    ComboBox createComboBox();
}

class SpringSkinFactory implements SkinFactory{
    public Button createButton() {
        return new SpringButton();
    }

    public TextField createTextField() {
        return new SpringTextField();
    }

    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}

class SummerSkinFactory implements SkinFactory{
    public Button createButton() {
        return new SummerButton();
    }

    public TextField createTextField() {
        return new SummerTextField();
    }

    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}

class Client{
    public static void main(String[] args) {
        SkinFactory factory=new SpringSkinFactory();
        Button button=factory.createButton();
        TextField textField=factory.createTextField();
        ComboBox comboBox=factory.createComboBox();

        button.display();
        textField.display();
        comboBox.display();
    }
}

