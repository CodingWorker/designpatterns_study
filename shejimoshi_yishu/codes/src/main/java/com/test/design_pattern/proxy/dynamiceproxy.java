package com.test.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class dynamiceproxy {
}

//抽象UserDAO:抽象主题角色
interface IUserDAO{
    boolean findUserById(String userId);
}

//抽象DocumentDAO:抽象主题角色
interface IDocumentDAO{
    boolean deleteDocumentById(String documentId);
}

//具体UserDAO类：真实角色
class UserDAO implements IUserDAO{
    public boolean findUserById(String userId) {
        if(userId.equalsIgnoreCase("userName")){
            System.out.println("查询ID为 "+userId+" 的用户信息成功");
            return true;
        }else{
            System.out.println("查询ID为 "+userId+" 的用户信息失败");
            return false;
        }
    }
}

class DocumentDAO implements IDocumentDAO{
    public boolean deleteDocumentById(String documentId) {
        if(documentId.equalsIgnoreCase("docId")){
            System.out.println("删除ID为 "+documentId+" 的文档信息成功");
            return true;
        }else{
            System.out.println("删除ID为 "+documentId+" 的文档信息失败");
            return false;
        }
    }
}

//自定义请求处理程序类
class DAOLogHandler implements InvocationHandler{
    private Calendar calendar;
    private Object object;
    public DAOLogHandler(){}

    public DAOLogHandler(Object o){
        this.object=o;
    }

    //实现invoke方法，调用在真实主题类中定义的方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        Object result=method.invoke(object,args);//转发调用
        afterInvoke();
        return result;
    }

    private void beforeInvoke(){
        calendar=new GregorianCalendar();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        int second=calendar.get(Calendar.SECOND);

        String time=hour+":"+minute+":"+second;
        System.out.println("调用时间 "+time);
    }

    private void afterInvoke(){
        System.out.println("方法调用结束");
    }
}

class Client2{
    public static void main(String[] args) {
        InvocationHandler handler=null;
        IUserDAO userDAO=new UserDAO();
        handler=new DAOLogHandler(userDAO);

        IUserDAO proxy;
        //动态创建代理对象，用于代理一个IUserDAO类型的真实主题对象
        //当该接口中的任何方法被调用时都会触发handler的invoke方法
        proxy=(IUserDAO) Proxy.newProxyInstance(IUserDAO.class.getClassLoader(),new Class[]{IUserDAO.class},handler);
        proxy.findUserById("userName");//调用代理对象代理的业务方法
        System.out.println("--------------------------------");
        IDocumentDAO docDao=new DocumentDAO();
        handler=new DAOLogHandler(docDao);
        IDocumentDAO proxy2;
        proxy2=(IDocumentDAO)Proxy.newProxyInstance(IDocumentDAO.class.getClassLoader(),new Class[]{IDocumentDAO.class},handler);
        proxy2.deleteDocumentById("docId");
    }
}
