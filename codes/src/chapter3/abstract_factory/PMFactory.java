package chapter3.abstract_factory;

/**
 * Created by DaiYan on 2017/4/22.
 */
public class PMFactory extends WidgetFactory {
    public PMWindow createWindow(){
        return new PMWindow();
    }

    public PMScrollBar createScrollBar(){
        return new PMScrollBar();
    }
}
