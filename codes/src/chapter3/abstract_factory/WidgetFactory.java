package chapter3.abstract_factory;

/**
 * Created by DaiYan on 2017/4/22.
 */
public abstract class WidgetFactory {
    abstract Window createWindow();
    abstract ScrollBar createScrollBar();
}
