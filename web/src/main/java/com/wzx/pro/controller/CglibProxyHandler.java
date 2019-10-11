package com.wzx.pro.controller;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyHandler implements MethodInterceptor {

    public Object proxy(Object realObject){

        // 使用字节码增强器 四个固定步骤：
        // 1、new字节码增强器
        // 2、设置当前类实例为回调
        // 3、将实际类实例设置为父类
        // 4、创建一个代理类
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(realObject.getClass());
        // 这里会生成代理类、代理类的FastClass辅助类、实际类的FastClass辅助类
        // 辅助类为代理类和实际类的每个方法生成一个唯一的id
        // 用于在调用intercept方法时，通过唯一id就可以调用对应的方法
        // 不再走反射机制，提高性能
        return enhancer.create();
    }

    /**
     *
     * @param o 代理类的实例
     * @param method 方法实例
     * @param objects 方法参数
     * @param methodProxy 方法代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("我是代理人：大明星唱歌开始前，我先宣传一下：巴拉巴拉。。。");

        // 这里如果使用 method.invoke方法，就等同于走了反射机制去调用方法，性能不高
        // 而且还需要另外维护实际类实例
        // Object ret = method.invoke(this.realObject, objects);

        Object ret = methodProxy.invokeSuper(o, objects);

        System.out.println("我是代理人：大明星唱歌完毕了，我来总结一下：巴拉巴拉。。。");

        return ret;
    }
}
