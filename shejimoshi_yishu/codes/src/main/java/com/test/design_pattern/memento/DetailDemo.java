package com.test.design_pattern.memento;

import java.awt.*;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/8
 */
public class DetailDemo {
}

//象棋棋子类：原发器
class Chessman{
    private String label;
    private int x;
    private int y;

    public Chessman(String label,int x,int y){
        this.label=label;
        this.x=x;
        this.y=y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    //保存状态
    public ChessmanMemento save(){
        return new ChessmanMemento(this.label,this.x,this.y);
    }

    //恢复状态
    public void restore(ChessmanMemento memento){
        this.label=memento.getLabel();
        this.x=memento.getX();
        this.y=memento.getY();
    }
}

//象棋棋子备忘录类：备忘录
class ChessmanMemento{
    private String label;
    private int x;
    private int y;

    public ChessmanMemento(String label,int x,int y){
        this.label=label;
        this.x=x;
        this.y=y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

//象棋棋子备忘录管理类：负责人
class MementoCaretaker{
    private ChessmanMemento chessmanMemento;

    public ChessmanMemento getChessmanMemento() {
        return chessmanMemento;
    }

    public void setChessmanMemento(ChessmanMemento chessmanMemento) {
        this.chessmanMemento = chessmanMemento;
    }
}

class Client{
    public static void main(String[] args) {
        MementoCaretaker mc = new MementoCaretaker();
        Chessman chess = new Chessman("车", 1, 1);
        display(chess);
        mc.setChessmanMemento(chess.save());//保存状态
        chess.setY(4);
        display(chess);
        mc.setChessmanMemento(chess.save());//保存状态
        display(chess);
        chess.setX(5);
        display(chess);
        System.out.println("-----------悔棋----------");
        chess.restore(mc.getChessmanMemento());
        display(chess);
    }

    private static void display(Chessman chess) {
        System.out.println("棋子：" + chess.getLabel() + " 当前位置为：第" + chess.getX() + "行，第" + chess.getY() + "列");
    }
}
