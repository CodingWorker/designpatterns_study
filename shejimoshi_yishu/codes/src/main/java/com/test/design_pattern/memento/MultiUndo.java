package com.test.design_pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/8
 */
public class MultiUndo {
}

class MementoCaretaker2{
    //定义一个集合来存储多个备忘录
    private List<ChessmanMemento> mementos=new ArrayList<ChessmanMemento>();

    public ChessmanMemento getMemento(int i){
        return this.mementos.get(i);
    }

    public void addMemento(ChessmanMemento memento){
        this.mementos.add(memento);
    }
}

class Client2{
    private static int index=-1;//定义一个索引来记录当前状态所在位置
    private static MementoCaretaker2 mc=new MementoCaretaker2();

    public static void main(String[] args) {
        Chessman chess=new Chessman("车",1,1);
        play(chess);
        display(chess);

        chess.setY(4);
        play(chess);
        display(chess);

        chess.setX(5);
        play(chess);
        display(chess);

        undo(chess,index);
        display(chess);
        undo(chess,index);
        display(chess);
        redo(chess,index);
        display(chess);
        redo(chess,index);
        display(chess);
    }

    //下棋
    public static void play(Chessman chess){
        mc.addMemento(chess.save());
        index++;
    }

    public static void display(Chessman chess){
        System.out.println("棋子：" + chess.getLabel() + " 当前位置为：第" + chess.getX() + "行，第" + chess.getY() + "列");
    }

    //悔棋
    public static void undo(Chessman chess,int i){
        System.out.println("————悔棋————");
        chess.restore(mc.getMemento(--index));
    }

    //撤销悔棋
    public static void redo(Chessman chess,int i){
        System.out.println("————撤销悔棋————");
        chess.restore(mc.getMemento(++index));
    }
}
