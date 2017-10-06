package com.test.design_pattern.chain;


/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class DetailDemo {
}

//采购单：请求类
class PurchaseRequest{
    private double amount;
    private int number;
    private String purpose;

    public PurchaseRequest(double amount,int number,String purpose){
        this.amount=amount;
        this.number=number;
        this.purpose=purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}

//审批者类：抽象处理者
abstract class Approver{
    protected Approver successor;//定义后继对象
    protected String name;//审批者的姓名

    public Approver(String name){
        this.name=name;
    }

    //设置后继者
    public void setSuccessor(Approver successor){
        this.successor=successor;
    }

    //抽象请求处理方法
    abstract public void processRequest(PurchaseRequest request);
}

//主任类：具体处理者
class Director extends Approver{
    public Director(String name){
        super(name);
    }

    public void processRequest(PurchaseRequest request){
        if(request.getAmount()<50000){
            System.out.println("主任 "+this.name+" 审批采购单："+request.getNumber()+", 金额："+request.getAmount()+" 元， 采购目的： "+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }
    }
}

//副董事长类：具体处理者
class VicePresident extends Approver{
    public VicePresident(String name){
        super(name);
    }

    public void processRequest(PurchaseRequest request){
        if(request.getAmount()<100000){
            System.out.println("副董事长 "+this.name+" 审批采购单："+request.getNumber()+", 金额："+request.getAmount()+" 元， 采购目的： "+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }
    }
}

//董事长类：具体处理者
class President extends Approver{
    public President(String name){
        super(name);
    }

    public void processRequest(PurchaseRequest request){
        if(request.getAmount()<500000){
            System.out.println("董事长 "+this.name+" 审批采购单："+request.getNumber()+", 金额："+request.getAmount()+" 元， 采购目的： "+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }
    }
}

//董事会类：具体处理者
class Congress extends Approver{
    public Congress(String name){
        super(name);
    }

    public void processRequest(PurchaseRequest request){
        if(request.getAmount()>=100000){
            System.out.println("董事会 "+this.name+" 审批采购单："+request.getNumber()+", 金额："+request.getAmount()+" 元， 采购目的： "+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }
    }
}

class Client{
    public static void main(String[] args) {
        Approver a,b,c,d;
        a=new Director("a主任");
        b=new VicePresident("b副董事长");
        c= new President("c董事长");
        d=new Congress("d董事会");

        //创建职责链
        a.setSuccessor(b);
        b.setSuccessor(c);
        c.setSuccessor(d);

        //创建采购单
        PurchaseRequest pr1=new PurchaseRequest(45000,10001,"购买倚天剑");
        a.processRequest(pr1);

        PurchaseRequest pr2=new PurchaseRequest(60000,10002,"购买屠龙刀");
        a.processRequest(pr2);

        PurchaseRequest pr3=new PurchaseRequest(160000,10003,"购买武林秘籍");
        a.processRequest(pr3);

        PurchaseRequest pr4=new PurchaseRequest(800000,10004,"购买武林");
        a.processRequest(pr4);
    }
}

