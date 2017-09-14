package com.test.designpattern._007.webfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class FilterChain implements Filter {
    private List<Filter> filters;
    private int index;

    public void addFilter(Filter filter){
        if(this.filters==null){
            this.filters=new ArrayList<Filter>();
        }

        this.filters.add(filter);
    }

    public void doFilter(Request req, Response resp, FilterChain filterChain){
        if(filters==null || index==filters.size()){
            return;
        }

        Filter filter=filters.get(index++);
        filter.doFilter(req,resp,filterChain);
    }
}
