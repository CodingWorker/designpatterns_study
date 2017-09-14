package com.test.designpattern._007;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class Message {
    private String msg;

    private Filter[] filters={new HtmlFilter(),new SentiveFilter()};
    public Message(){}

    public void process(){
        for(Filter filter:filters){
            filter.doFilter(this.msg);
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
