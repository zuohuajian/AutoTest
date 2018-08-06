package com.course.httpclient.demo;

public class openapiurl {

    public static String[] openapi=new String[200];

    public String url(int a){
        openapi[0]="http://m.api.haoshiqi.net/common/initconfig";
        openapi[1]="http://m.api.haoshiqi.net/common/verifyupgrade";
        return openapi[a];
    }

    public static void main (String[] args){
        openapiurl myurl = new openapiurl();
        String b = myurl.url(0);
//        for (String x : openapi) {
//            if(x==null){
//                break;
//            }
//            System.out.println(x);
//        }
        for (int a=0;a<openapi.length;a++) {
            String x= openapi[a];
            if(x==null){
                break;
            }
            String result;
            System.out.println(x);
        }
        System.out.println(b);
    }
}
