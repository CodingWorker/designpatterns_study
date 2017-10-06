package com.test.design_pattern.facade;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/10/6
 */
public class AbstractFacade {
}

class NewCipherMachine{
    public String encrypt(String plainText){
        //具体加密算法
        return null;
    }
}

abstract class AbstractEncryptFacade{
    abstract public void fileEncrypt(String fileNameSrc,String fileNameDes);
}

//新加密外观类，具体外观类
class NewEncyptFacade extends AbstractEncryptFacade{
    private FileReader reader;
    private NewCipherMachine cipher;
    private FileWrier wrier;

    public NewEncyptFacade(){
        this.reader=new FileReader();
        this.cipher=new NewCipherMachine();
        this.wrier=new FileWrier();
    }

    @Override
    public void fileEncrypt(String fileNameSrc, String fileNameDes) {
        String plainText= this.reader.read(fileNameSrc);
        String encryptStr=this.cipher.encrypt(plainText);
        this.wrier.write(encryptStr,fileNameDes);
    }
}

class Client2{
    public static void main(String[] args) {
        AbstractEncryptFacade ef=new NewEncyptFacade();
        ef.fileEncrypt("origin.txt","encrypt.txt");
    }
}