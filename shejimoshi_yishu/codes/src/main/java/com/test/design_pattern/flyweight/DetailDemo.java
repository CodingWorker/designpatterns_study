package com.test.design_pattern.flyweight;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class DetailDemo {
}

class Coordinates{
    private int x;
    private int y;

    public Coordinates(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

//围棋棋子类，抽象享元类
abstract class IgoChessman{
    abstract public String getColor();
    public void display(Coordinates coord){
        System.out.println("棋子颜色："+this.getColor()+", 棋子位置: "+coord.getX()+", "+coord.getY());
    }
}

//黑色棋子类：具体享元类
class BlackIgoChessman extends IgoChessman{
    public String getColor(){
        return "黑色";
    }
}

//白色棋子类：具体享元类
class WhiteIgoChessman extends IgoChessman{
    public String getColor(){
        return "白色";
    }
}

//围棋棋子工厂类，享元工厂类，使用单例模式进行设计
class IgoChessmanFactory{
    private static IgoChessmanFactory instance=new IgoChessmanFactory();
    private static Map<String,IgoChessman> igoChessmanMap;

    private IgoChessmanFactory(){
        igoChessmanMap=new Hashtable<String, IgoChessman>();

        IgoChessman black,white;
        black=new BlackIgoChessman();
        white=new WhiteIgoChessman();

        igoChessmanMap.put("b",black);
        igoChessmanMap.put("w",white);
    }

    public static IgoChessmanFactory getInstance(){
        return instance;
    }

    //通过key获取存储在HashTable中的享元对象
    public IgoChessman getIgoChessman(String key){
        return igoChessmanMap.get(key);
    }
}

class Client{
    public static void main(String[] args) {
        IgoChessman black1,black2,black3,white1,white2;
        IgoChessmanFactory factory;

        factory=IgoChessmanFactory.getInstance();

        black1=factory.getIgoChessman("b");
        black2=factory.getIgoChessman("b");
        black3=factory.getIgoChessman("b");
        System.out.println("black1==black2? "+(black1==black2));

        white1=factory.getIgoChessman("w");
        white2=factory.getIgoChessman("w");
        System.out.println("white1==white2? "+(white1==white2));

        black1.display(new Coordinates(1,2));
        black2.display(new Coordinates(2,3));
        black3.display(new Coordinates(3,4));
        white1.display(new Coordinates(5,6));
        white2.display(new Coordinates(6,7));
    }
}
