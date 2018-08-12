package com.course.httpclient.cookies;

import com.sun.security.ntlm.Client;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class MycookiesForPost {
    private String url;
    private ResourceBundle bundle;

    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CANADA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
//        从配置文件中拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
//        逻辑代码的书写
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookis信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie:cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("Cookie name = "+ name + ";Cookie value = " + value);
        }

    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPost() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        //拼接最终的测试地址
        String testurl = this.url + uri;

        //声明一个client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testurl);
        //添加参数
//        添加json参数
//        JSONObject param = new JSONObject();
//        param.put("name","huhansan");
//        param.put("age","18");
        //添加froms参数
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("name", "huhansan");
        BasicNameValuePair param2 = new BasicNameValuePair("age", "18");
        list.add(param1);
        list.add(param2);
        UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(list, "UTF-8");
        post.setEntity(entityParam);


        //设置请求头信息 设置header信息
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
//        StringEntity entity = new StringEntity(param.toString(),"utf-8");
//        post.setEntity(entity);
        //声明一个对象进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，就是判断返回结果是否符合预期
        //将返回的响应即如果字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
        //获取到结果值
        String success = (String) resultJson.get("huhansan");
        String status = resultJson.getString("status");
        //具体的判断返回的结果值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
