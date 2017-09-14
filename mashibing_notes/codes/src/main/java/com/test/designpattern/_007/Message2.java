package com.test.designpattern._007;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class Message2 {
    private String msg;

    private FilterChain filterChain;

    public Message2() {
    }

    public void process() {
        this.filterChain.doFilter(this.msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FilterChain getFilterChain() {
        return filterChain;
    }

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }
}
