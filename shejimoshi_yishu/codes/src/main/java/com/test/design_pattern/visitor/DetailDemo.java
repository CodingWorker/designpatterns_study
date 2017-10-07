package com.test.design_pattern.visitor;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/7
 */
public class DetailDemo {
}

//员工类：抽象元素类
interface Employee{
    void accpet(Department handler);//接收一个抽象访问者访问
}

//企业员工类：具体元素
class FullTimeEmployee implements Employee{
    private String name;
    private double weeklyWage;
    private int workTime;

    public FullTimeEmployee(String name,double weeklyWage,int workTime){
        this.name=name;
        this.weeklyWage=  weeklyWage;
        this.workTime=workTime;
    }

    public void accpet(Department handler) {
        handler.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeeklyWage() {
        return weeklyWage;
    }

    public void setWeeklyWage(double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}

//兼职员工类：具体元素
class PartTimeEmployee implements Employee{
    private String name;
    private double hourWage;
    private int workTime;

    public PartTimeEmployee(String name,double hourWage,int workTime){
        this.name=name;
        this.hourWage=hourWage;
        this.workTime=workTime;
    }

    public void accpet(Department handler) {
        handler.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourWage() {
        return hourWage;
    }

    public void setHourWage(double hourWage) {
        this.hourWage = hourWage;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}

//部门类：抽象访问类
abstract class Department{
    abstract public void visit(FullTimeEmployee employee);
    abstract public void visit(PartTimeEmployee employee);
}

//财务部：具体访问类
class FADepartment extends Department{
    //实现财务部对全职员工的访问
    public void visit(FullTimeEmployee employee){
        int workTime=employee.getWorkTime();
        double weekWage=employee.getWeeklyWage();

        if(workTime>40){
            weekWage=weekWage+(workTime-40)*100;
        }else if(workTime<40){
            weekWage=weekWage-(40-workTime)*80;
            if(weekWage<0){
                weekWage=0;
            }
        }

        System.out.println("正式员工 "+employee.getName()+" 实际工资为："+weekWage+" 元");
    }

    //实现财务部对兼职员工的访问
    public void visit(PartTimeEmployee employee){
        int workTime=employee.getWorkTime();
        double hourWage=employee.getHourWage();

        System.out.println("临时员工 "+employee.getName()+" 实际工资为："+hourWage*workTime+" 元");
    }
}

//人力资源类：具体访问者类
class HRDepartment extends Department{
    public void visit(FullTimeEmployee employee){
        int workTime=employee.getWorkTime();
        System.out.println("正式员工 "+employee.getName()+" 实际工作时间为："+workTime+" 小时");
        if(workTime>40){
            System.out.println("正式员工 "+employee.getName()+" 实际加班时间为："+(workTime-40)+" 小时");
        }else if(workTime<40){
            System.out.println("正式员工 "+employee.getName()+" 实际请假时间为："+(40-workTime)+" 小时");
        }
    }

    //实现人力资源部对兼职员工的访问
    public void visit(PartTimeEmployee employee){
        int workTime=employee.getWorkTime();
        double hourWage=employee.getHourWage();

        System.out.println("临时员工 "+employee.getName()+" 实际工作时间为："+workTime+" 小时");
    }
}

//员工列表类：对象结构
class EmployeeList{
    private List<Employee> employeeList=new ArrayList<Employee>();

    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }

    public void removeEmployee(Employee employee){
        this.employeeList.remove(employee);
    }

    public void accpet(Department handler){
        for(Employee employee:employeeList){
            employee.accpet(handler);
        }
    }
}

class Client{
    public static void main(String[] args) {
        EmployeeList list=new EmployeeList();
        Employee f1,f2,f3,p1,p2;
        f1=new FullTimeEmployee("a",3200.00,45);
        f2=new FullTimeEmployee("b",2000.00,40);
        f3=new FullTimeEmployee("c",2400.00,38);
        p1=new PartTimeEmployee("d",80.00,20);
        p2=new PartTimeEmployee("e",60.00,18);

        list.addEmployee(f1);
        list.addEmployee(f2);
        list.addEmployee(f3);
        list.addEmployee(p1);
        list.addEmployee(p2);

        Department dep1=new FADepartment();
        list.accpet(dep1);

        Department dep2=new HRDepartment();
        list.accpet(dep2);
    }
}