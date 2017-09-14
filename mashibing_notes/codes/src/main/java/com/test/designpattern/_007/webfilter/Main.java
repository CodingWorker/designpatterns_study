package com.test.designpattern._007.webfilter;

/**
 * Created by DaiYan on 2017/9/14.
 */
public class Main {
    public static void main(String[] args){
        Request request=new Request();
        request.setReqStr("这<script>并非敏感，也并非特殊，仅仅是个测试");
        Response response=new Response();

        response.setRespStr("这<script>并非敏感，也并非特殊，仅仅是个测试");
        FilterChain filterChain=new FilterChain();
        filterChain.addFilter(new HtmlFilter());
        filterChain.addFilter(new SentiveFilter());

        filterChain.doFilter(request,response,filterChain);
        System.out.println(request.getReqStr());
        System.out.println(response.getRespStr());
    }
}
