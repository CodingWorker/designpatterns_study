package com.test.design_pattern.template;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class DetailDemo {
}

//账户类：抽象类
abstract class Account{
    //基本方法：具体方法
    public boolean validate(String account,String password){
        System.out.println("账号："+account);
        System.out.println("密码："+password);
        return account.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("admin");
    }

    //基本方法：抽象方法
    abstract public void calculateInterest();

    //模板方法：具体方法
    public void display(){
        System.out.println("显示利息");
    }

    //模板方法
    public void handle(String account,String password){
        if(!validate(account,password)){
            System.out.println("账户或密码错误");
            return;
        }

        calculateInterest();
        display();
    }
}

//获取账户类：具体子类
class SavingAccount extends Account{
    //覆盖父类的抽象方法
    public void calculateInterest(){
        System.out.println("按定期利率计算利息");
    }
}

class Client{
    public static void main(String[] args) {
        Account account=new SavingAccount();
        account.handle("admin","admin");
    }
}