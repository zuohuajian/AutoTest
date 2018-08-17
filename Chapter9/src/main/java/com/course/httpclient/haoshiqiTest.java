package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.CookieStore;
import java.util.Locale;
import java.util.ResourceBundle;

public class haoshiqiTest {
    //储存url
    private String url;
    private ResourceBundle bundle;
    //储存cookie信息
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("haoshiqiAppliction", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    @Test
    public void testCommonInitconfig() throws IOException {
        //拼接测试url
        String uri = bundle.getString("test.common.initconfig");
        String testUrl = this.url + uri;
        //定义存放的结果
        String result;
        //请求get接口
        HttpGet get = new HttpGet(testUrl);
        //取出返回结果
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


    }
}
