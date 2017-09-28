package chapter3.abstract_factory;

/**
 * Created by DaiYan on 2017/4/22.
 */
public class MotifFactory extends WidgetFactory{
    private static MotifFactory _mf=new MotifFactory();
    public MotifWindow createWindow(){
        return new MotifWindow();
    }

    public MotifScrollBar createScrollBar(){
        return new MotifScrollBar();
    }

    //将具体工厂实现为单例
    private MotifFactory(){}

    public static MotifFactory getInstance(){
        return _mf;
    }
}
