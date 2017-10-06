package com.test.design_pattern.facade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class DetailDemo {
}

//文件读取子系统
class FileReader{
    public String read(String fileNameSrc) {
        System.out.println("读取文件，获取明文: ");
        StringBuffer sb = new StringBuffer();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileNameSrc);
            int data;
            while ((data = fis.read()) != -1) {
                sb.append((char) data);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        return sb.toString();
    }
}

//数据加密类：子系统
class CipherMachine{
    public String encrypt(String plainText){
        System.out.println("数据加密，将明文转换为密文: ");
        String es="";
        for(int i=0;i<plainText.length();i++){
            String c=String.valueOf(plainText.charAt(i)%7);
            es+=c;
        }

        System.out.println(es);
        return es;
    }
}

class FileWrier{
    public void write(String encryptStr,String fileNameDes){
        System.out.println("保存密文，写入文件: ");
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream(fileNameDes);
            fos.write(encryptStr.getBytes());
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            if(null!=fos){
                try{
                    fos.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}

//加密外观类：外观类
class EncryptFacade{
    private FileReader reader;
    private CipherMachine cipher;
    private FileWrier writer;

    public EncryptFacade(){
        this.reader=new FileReader();
        this.cipher=new CipherMachine();
        this.writer=new FileWrier();
    }

    //调用其对象的业务方法
    public void fileEncrypt(String fileNameSrc,String fileNameDes){
        String plainText=this.reader.read(fileNameSrc);
        String encryptStr=this.cipher.encrypt(plainText);
        this.writer.write(encryptStr,fileNameDes);
    }
}

class Client{
    public static void main(String[] args) {
        EncryptFacade ef=new EncryptFacade();
        ef.fileEncrypt("origin.txt","encrypt.txt");
    }
}


