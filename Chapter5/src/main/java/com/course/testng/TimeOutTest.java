package com.course.testng;

import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class TimeOutTest {


    @Test(timeOut = 3000)//单位为毫秒值
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {

        System.out.println("超时了");
        Thread.sleep(3000);
    }


}
