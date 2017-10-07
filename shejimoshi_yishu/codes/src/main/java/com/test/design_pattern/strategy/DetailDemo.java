package com.test.design_pattern.strategy;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class DetailDemo {
}

//折扣类：抽象策略类
interface Discount{
    public double calculate(double price);
}

//学生票折扣类：具体策略类
class StudentDiscount implements Discount{
    public double calculate(double price) {
        System.out.println("学生票：");
        return price*0.8;
    }
}

//儿童票折扣类：具体策略类
class ChildrenDiscount implements Discount{
    public double calculate(double price) {
        System.out.println("儿童票：");
        return price-10;
    }
}

//VIP会员票折扣类：具体策略类
class VIPDiscount implements Discount{
    public double calculate(double price) {
        System.out.println("VIP票：");
        return price*0.5;
    }
}

//电影票类：环境类
class MovieTicket{
    private double price;
    private Discount discount;//维持一个对抽象类算法的引用

    public void setPrice(double price){
        this.price=price;
    }

    public void setDiscount(Discount discount){
        this.discount=discount;
    }

    public double getPrice(){
        return this.discount.calculate(this.price);
    }
}

class Client2{
    public static void main(String[] args) {
        MovieTicket mt=new MovieTicket();
        double originalPrice=60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价格为："+originalPrice);
        System.out.println("--------------------");

        Discount discount=new StudentDiscount();
        mt.setDiscount(discount);
        currentPrice=mt.getPrice();
        System.out.println("折后价为："+currentPrice);
    }
}
