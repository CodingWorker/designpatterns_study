package com.test.design_pattern.component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class DetailDemo {
}

abstract class AbstractFile{
    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}

class ImageFile extends AbstractFile{
    private String name;
    public ImageFile(String name){
        this.name=name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("---- 对图像文件 '"+this.name+"' 进行杀毒");
    }
}

class TextFile extends AbstractFile{
    private String name;
    public TextFile(String name){
        this.name=name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("---- 对文本文件 '"+this.name+"' 进行杀毒");
    }
}

class VideoFile extends AbstractFile{
    private String name;
    public VideoFile(String name){
        this.name=name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("对不起，不支持该方法");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("对不起，不支持该方法");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("对不起，不支持该方法");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("---- 对视频文件 '"+this.name+"' 进行杀毒");
    }
}

class Folder extends AbstractFile{
    private List<AbstractFile> list=new ArrayList<AbstractFile>();
    private String name;
    public Folder(String name){
        this.name=name;
    }

    @Override
    public void add(AbstractFile file) {
        list.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        list.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return list.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("**** 对文件夹 '"+this.name+"' 进行杀毒");
        for(AbstractFile file:list){
            file.killVirus();
        }
    }
}

class Client{
    public static void main(String[] args) {
        AbstractFile file1,file2,file3,file4,file5,folder1,folder2,folder3,folder4;

        folder1=new Folder("sunny 的资料");
        folder2=new Folder("图像文件");
        folder3=new Folder("文本文件");
        folder4=new Folder("视频文件");

        file1=new ImageFile("a.jpg");
        file2=new ImageFile("b.gif");
        file3=new TextFile("c.txt");
        file4=new TextFile("d.doc");
        file5=new VideoFile("e.rmvb");

        //图像目录
        folder2.add(file1);
        folder2.add(file2);

        //文本目录
        folder3.add(file3);
        folder3.add(file4);

        //视频目录
        folder4.add(file5);

        //sunny 目录
        folder1.add(folder2);
        folder2.add(folder3);
        folder1.add(folder4);

        //对sunny 目录进行杀毒
        folder1.killVirus();
    }
}


