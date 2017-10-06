package com.test.design_pattern.proxy;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class DetailDemo {
}

//抽象查询类：抽象主题类
interface Searcher{
    String doSearch(String userId,String keyword);
}

//身份验证类：业务类
class AccessValidator{
    //模拟实现登陆验证
    public boolean validate(String userId){
        System.out.println("在数据库中验证用户 "+userId+" 是否合法");
        if(userId.equalsIgnoreCase("userName")){
            System.out.println("userId: "+userId+" 登陆成功");
            return true;
        }else{
            System.out.println("userId: "+userId+" 登陆失败");
            return false;
        }
    }
}

//日志记录类：业务类
class Logger{
    //模拟日志记录
    public void log(String userId){
        System.out.println("更新数据库，用户："+userId+" 查询此数+1");
    }
}

//具体查询类：真实主题
class RealSearcher implements Searcher{
    public String doSearch(String userId, String keyword) {
        System.out.println("用户 "+userId+" 使用关键词 "+keyword+" 查询商务信息");
        return "返回具体内容";
    }
}

class ProxySearcher implements Searcher{
    private Searcher searcher;
    private AccessValidator validator;
    private Logger logger;

    public ProxySearcher(){
        this.searcher=new RealSearcher();
        this.validator=new AccessValidator();
        this.logger=new Logger();
    }

    public boolean validate(String userId){
        return this.validator.validate(userId);
    }

    public void log(String userId){
        this.logger.log(userId);
    }

    public String doSearch(String userId, String keyword) {
        if(validate(userId)){
            String result=this.searcher.doSearch(userId,keyword);
            this.log(userId);
            return result;
        }else{
            return null;
        }
    }
}

class Client{
    public static void main(String[] args) {
        Searcher searcher=new ProxySearcher();
        System.out.println(searcher.doSearch("user","keyword"));
        System.out.println(searcher.doSearch("userName","keyword"));
    }
}