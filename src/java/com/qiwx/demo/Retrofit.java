package com.qiwx.demo;

import java.lang.reflect.Proxy;

public class Retrofit {
    public static <T> T newProxy(Class<T> clazz){
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new RequestHandler());
    }
}
