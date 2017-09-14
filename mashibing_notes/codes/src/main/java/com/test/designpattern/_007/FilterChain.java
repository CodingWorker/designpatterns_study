package com.test.designpattern._007;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class FilterChain implements  Filter{
    private List<Filter> filters=new ArrayList<Filter>();

    public FilterChain addFilter(Filter filter){
        this.filters.add(filter);
        return this;
    }

    public void doFilter(String msg){
        for(Filter filter:filters){
            filter.doFilter(msg);
        }
    }
}
