package com.test.designpattern._007.webfilter;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class SentiveFilter implements Filter {
    public void doFilter(Request req, Response resp, FilterChain filterChain){
        req.setReqStr(req.getReqStr().replace("敏感","(mingan)").replace("特殊","(teshu)")+"---Sentive Filter");
        filterChain.doFilter(req,resp,filterChain);
        resp.setRespStr(resp.getRespStr()+"--Sentive Filter");
    }
}
