package com.wzx.pro.controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyHandler implements InvocationHandler {

    private Object realObject;

    public Object proxy(Object realObject){
        this.realObject = realObject;
        return Proxy.newProxyInstance(this.realObject.getClass().getClassLoader(),
                this.realObject.getClass().getInterfaces(), this);
    }

    /**
     *
     * @param proxy 动态生成的代理类实例
     * @param method 方法实例
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理人：大明星唱歌开始前，我先宣传一下：巴拉巴拉。。。");

        // 调用实际类的方法，并传入参数，内部是反射机制
        Object ret = method.invoke(this.realObject, args);

        System.out.println("我是代理人：大明星唱歌完毕了，我来总结一下：巴拉巴拉。。。");

        return ret;
    }
}