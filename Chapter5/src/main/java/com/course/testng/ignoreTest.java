package com.course.testng;

import org.testng.annotations.Test;

public class ignoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1执行");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2执行");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3执行");
    }






}

