package com.test.designpattern._007.webfilter;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class HtmlFilter implements Filter{
    public void doFilter(Request req, Response resp, FilterChain filterChain){
        req.setReqStr(req.getReqStr().replace("<","[").replace(">","]")+"---Html Filter");
        filterChain.doFilter(req,resp,filterChain);
        resp.setRespStr(resp.getRespStr()+"--Html Filter");
    }
}
