package com.test.design_pattern.singleton;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/28
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 单例模式的实例：
 *      负载均衡器的实现
 */
public class LoadBalancer{
    private static LoadBalancer instance=new LoadBalancer();

    /**
     * 服务器列表
     */
    private List<String> serveList=null;

    private LoadBalancer(){
        serveList=new ArrayList<String>();
    }

    public static LoadBalancer GetInstance(){
        return instance;
    }

    /**
     * add server
     */
    public void addServer(String server){
        this.serveList.add(server);
    }

    /**
     * remove server
     */
    public void removeServer(String server){
        this.serveList.remove(server);
    }

    /**
     * 负载均衡：随机获取一个服务器
     * 负载均衡：随机获取一个服务器
     */
    public String getRandom(){
        int size=this.serveList.size();
        if(0==this.serveList.size()) return null;

        int index=new Random().nextInt(size);
        return this.serveList.get(index);
    }

    public static void main(String[] args) {
        LoadBalancer loadBalancer=LoadBalancer.GetInstance();
        loadBalancer.addServer("server1");
        loadBalancer.addServer("server2");
        loadBalancer.addServer("server3");
        loadBalancer.addServer("server4");
        loadBalancer.addServer("server5");

        System.out.println(loadBalancer.getRandom());
        System.out.println(loadBalancer.getRandom());

    }
}
