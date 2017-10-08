package com.test.design_pattern.state;


/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/8
 */
public class DetailDemo {
}

//银行账户：环境类
class Account{
    private AccountState state;//维持一个对抽象状态的引用
    private String owner;//开户名
    private double balance=0;//账户余额

    public Account(String owner,double init){
        this.owner=owner;
        this.balance=init;
        this.state=new NormalState(this);//设置初始状态
        System.out.println(this.owner+" 开户，初始账户余额为："+this.balance);
        System.out.println("——————————————");
    }

    public void deposit(double amount){
        System.out.println(this.owner+" 存款"+amount);
        state.deposit(amount);
        System.out.println("现在余额为："+this.balance);
        System.out.println("现在状态为："+this.state.getClass().getName());
        System.out.println("——————————————");
    }

    public void withdraw(double amount){
        System.out.println(this.owner+" 取款"+amount);
        state.withdraw(amount);
        System.out.println("现在余额为："+this.balance);
        System.out.println("现在状态为："+this.state.getClass().getName());
        System.out.println("——————————————");
    }

    public void computeInterest(){
        state.computeInterest();
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

//抽象状态类
abstract class AccountState{
    protected Account acc;
    abstract public void deposit(double amount);
    abstract public void withdraw(double amount);
    abstract public void computeInterest();
    abstract public void stateCheck();
}

//正常状态
class NormalState extends AccountState{
    public NormalState(Account acc){
        this.acc=acc;
    }

    public NormalState(AccountState state){
        this.acc=state.acc;
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance()- amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("正常状态，无需支付利息");
    }

    @Override
    public void stateCheck() {//状态转换
        if(acc.getBalance()>-2000 && acc.getBalance()<=0){
            acc.setState(new OverdraftState(this));
        }else if(acc.getBalance()==-2000){
            acc.setState(new RestrictedState(this));
        }else if(acc.getBalance()<-2000){
            System.out.println("操作受限");
        }
    }
}

//透支状态：具体状态类
class OverdraftState extends AccountState{
    public OverdraftState(Account acc){
        this.acc=acc;
    }

    public OverdraftState(AccountState state){
        this.acc=state.acc;
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance()-amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息");
    }

    @Override
    public void stateCheck() {
        if(acc.getBalance()>0){
            acc.setState(new NormalState(this));
        }else if(acc.getBalance()==-2000){
            acc.setState(new RestrictedState(this));
        }else if(acc.getBalance()<-2000){
            System.out.println("操作受限");
        }
    }
}

//受限状态：具体状态类
class RestrictedState extends AccountState{
    public RestrictedState(Account acc){
        this.acc=acc;
    }

    public RestrictedState(AccountState state){
        this.acc=state.acc;
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("账户受限，取款失败");
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息");
    }

    @Override
    public void stateCheck() {
        if(acc.getBalance()>0){
            acc.setState(new NormalState(this));
        }else if(acc.getBalance()>-2000){
            acc.setState(new OverdraftState(this));
        }
    }
}

class Client{
    public static void main(String[] args) {
        Account acc=new Account("段誉",0.0);
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(4000);
        acc.withdraw(1000);
        acc.computeInterest();
    }
}