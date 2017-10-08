package com.test.design_pattern.mediator;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/8
 */
public class DetailDemo {
}

//抽象中介者
abstract class Mediator2{
    abstract public void componentChanged(Component c);
}

//具体中介者
class ConcreteMediator2 extends Mediator2{
    //维持对各个同事对象的引用
    private Button addButton;
    private List list;
    private TextBox textBox;
    private ComboBox comboBox;

    //封装同事对象之间的交互
    public void componentChanged(Component c){
        //单击按钮
        if(c==addButton){
            System.out.println("——单击增加按钮——");
            list.update();
            comboBox.update();
            textBox.update();
        }else if(c==list){
            System.out.println("——从列表框选择客户——");
            comboBox.select();
            textBox.setText();
        }else if(c==comboBox){
            System.out.println("——从组合框选择客户——");
            comboBox.select();
            textBox.setText();
        }
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    public ComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(ComboBox comboBox) {
        this.comboBox = comboBox;
    }
}

//抽象组件类：抽象同事类
abstract class Component{
    protected Mediator2 mediator;

    public void setMediator(Mediator2 mediator){
        this.mediator=mediator;
    }

    //转发调用
    public void changed(){
        mediator.componentChanged(this);
    }

    abstract public void update();
}

class Button extends Component{
    public void update(){
        //按钮不产生响应
    }
}

class List extends Component{
    @Override
    public void update() {
        System.out.println("列表框增加一项：A");
    }

    public void select(){
        System.out.println("列表框选中项：Aa");
    }
}

class ComboBox extends Component{
    @Override
    public void update() {
        System.out.println("组合框增加一项：A");
    }

    public void select(){
        System.out.println("组合框选中一项：Aa");
    }
}

class TextBox extends Component{
    @Override
    public void update() {
        System.out.println("客户信息增加成功后文本框清空");
    }

    public void setText(){
        System.out.println("文本框显示：Aa");
    }
}

class Client{
    public static void main(String[] args) {
        //定义中介者对象
        ConcreteMediator2 mediator=new ConcreteMediator2();

        //定义同事对象
        Button addBT=new Button();
        List list=new List();
        ComboBox comboBox=new ComboBox();
        TextBox textBox=new TextBox();

        addBT.setMediator(mediator);
        list.setMediator(mediator);
        comboBox.setMediator(mediator);
        textBox.setMediator(mediator);

        mediator.setAddButton(addBT);
        mediator.setList(list);
        mediator.setComboBox(comboBox);
        mediator.setTextBox(textBox);

        addBT.changed();
        System.out.println("-----------------------");
        list.changed();
    }
}
