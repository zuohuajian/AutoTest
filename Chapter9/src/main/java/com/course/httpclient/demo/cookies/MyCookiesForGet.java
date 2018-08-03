package com.course.httpclient.demo.cookies;

import org.testng.annotations.BeforeTest;

import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("appliction" );
        System.out.println(bundle);
    }
}
