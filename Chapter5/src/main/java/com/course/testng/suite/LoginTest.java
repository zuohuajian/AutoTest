package com.course.testng.suite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginTaoBao(){
        System.out.println("淘宝登录成功");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before Method 运行啦");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after Method运行啦");
    }

}
