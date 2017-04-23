package chapter3.abstract_factory;

/**
 * Created by DaiYan on 2017/4/22.
 */
public class Client {
    public static void main(String[] args){
        WidgetFactory wf=new PMFactory();
        Window w1=wf.createWindow();
        ScrollBar sb1=wf.createScrollBar();

        WidgetFactory wf2=new MotifFactory();
        Window w2=wf2.createWindow();
        ScrollBar sb2=wf2.createScrollBar();
    }
}
