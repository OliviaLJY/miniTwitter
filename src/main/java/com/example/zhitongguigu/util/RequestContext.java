package com.example.zhitongguigu.util;

import java.io.Serializable;

public class RequestContext implements Serializable {
    // User GUID
    // time, IP etc
    private static ThreadLocal<String> remoteAddr = new ThreadLocal<>();

    public static String getRemoteAddr() {
        return remoteAddr.get();
    }

    public static void setRemoteAddr(String remoteAddr){
        RequestContext.remoteAddr.set(remoteAddr);
    }
}
