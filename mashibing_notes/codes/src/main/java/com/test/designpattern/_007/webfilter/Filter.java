package com.test.designpattern._007.webfilter;

/**
 * Created by DaiYan on 2017/9/14.
 */
public interface Filter {
    void doFilter(Request req, Response resp, FilterChain filterChain);
}
