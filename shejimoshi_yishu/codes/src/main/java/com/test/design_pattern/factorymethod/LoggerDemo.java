package com.test.design_pattern.factorymethod;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/29
 */
public class LoggerDemo {
}

interface ILogger{
    void log(String msg);
}

class FileLogger implements ILogger{
    public void log(String msg) {
        //log to file
    }
}

class DataBaseLogger implements ILogger{
    public void log(String msg) {
        //log to db
    }
}

interface ILoggerFactory{
    ILogger createLogger();
}

class FileLoggerFactory implements ILoggerFactory{
    public ILogger createLogger() {
        return new FileLogger();
    }
}

class DataBaseLoggerFactory implements ILoggerFactory{
    public ILogger createLogger() {
        return new DataBaseLogger();
    }
}

class LoggerTest{
    public static void main(String[] args) {
        ILogger logger=new FileLoggerFactory().createLogger();
        logger.log("logging ...");
    }
}

class Client {
    public static ILogger getLogger() {
        ILogger iLogger = null;
        //klassName from xml or db
        String klassName = null;
        try {
            Class kclass = Class.forName(klassName);
            iLogger = ((ILoggerFactory) kclass.newInstance()).createLogger();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.fillInStackTrace();
        } catch (InstantiationException ex) {
            ex.fillInStackTrace();
        }

        return iLogger;
    }

    //other code
}

//another impl
abstract class AbstractLoggerFactory{
    public void log(String msg){
        //log
        ILogger logger=this.createLogger();
        logger.log(msg);
    }

    abstract ILogger createLogger();
}

class FileLoggerFactory2 extends AbstractLoggerFactory{
    @Override
    ILogger createLogger() {
        return new FileLogger();
    }
}

class Client2 {
    public static void main(String[] args) {
        //from config .etc
        String klassName = null;
        try {
            Object loggerFactory = (Class.forName(klassName)).newInstance();
            ((AbstractLoggerFactory)loggerFactory).log("logging ...");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }catch(IllegalAccessException ex){
            ex.fillInStackTrace();
        }
    }
}