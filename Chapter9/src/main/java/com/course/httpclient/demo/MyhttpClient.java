package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyhttpClient {

    @Test(testName = "1")
    public void test1() throws IOException {
        //用来存放测试结果
        openapiurl myurl = new openapiurl();
        String result;
        HttpGet get = new HttpGet(myurl.url(0));
        //这个是用来执行get方法的
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }

    @Test(testName = "2")
    public void test2() throws IOException {

        //用来存放测试结果
        String result;
        HttpGet get = new HttpGet("http://m.api.haoshiqi.net/common/verifyupgrade");
        //这个是用来执行get方法的
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }




}
