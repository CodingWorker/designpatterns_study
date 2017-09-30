package com.test.design_pattern.builder;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class ViewApacheHttpClient {
    public static void main(String[] args) {
        HttpClient client= HttpClients.custom()
                .setMaxConnTotal(1000)
                .build();
    }
}
