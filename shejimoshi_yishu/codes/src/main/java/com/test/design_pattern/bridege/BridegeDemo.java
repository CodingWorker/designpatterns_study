package com.test.design_pattern.bridege;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class BridegeDemo {
}

class Matrix{}

abstract class Image{
    protected ImageImp imp;
    public void setImp(ImageImp imp){
        this.imp=imp;
    }

    public abstract void parseFile(String fileName);
}

interface ImageImp{
    public void doPaint(Matrix m);
}

class WindowsImp implements ImageImp{
    public void doPaint(Matrix m) {
        System.out.println("windows do paint");
    }
}

class UnixImp implements ImageImp{
    public void doPaint(Matrix m) {
        System.out.println("Unix do paint");
    }
}
class JPGImage extends Image{
    public void parseFile(String fileName){
        Matrix m=new Matrix();
        imp.doPaint(m);
        System.out.println(fileName+" ,格式为JPG");
    }
}

class PNGImage extends Image{
    @Override
    public void parseFile(String fileName) {
        Matrix m=new Matrix();
        imp.doPaint(m);
        System.out.println(fileName+" ,格式为PNG");
    }
}

class BMPImage extends Image{
    @Override
    public void parseFile(String fileName) {
        Matrix m=new Matrix();
        imp.doPaint(m);
        System.out.println(fileName+" ,格式为BMP");
    }
}

class GIFImage extends Image{
    @Override
    public void parseFile(String fileName) {
        Matrix m=new Matrix();
        imp.doPaint(m);
        System.out.println(fileName+" ,格式为GIF");
    }
}

class Client{
    public static void main(String[] args) {
        Image image;
        ImageImp imp=new WindowsImp();
        image=new JPGImage();
        image.setImp(imp);
        image.parseFile("");
    }
}