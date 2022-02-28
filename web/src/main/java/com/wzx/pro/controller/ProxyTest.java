package com.wzx.pro.controller;

import com.wzx.pro.impl.SeckillServiceImpl;
import org.springframework.cglib.core.DebuggingClassWriter;

public class ProxyTest {
    public static void main(String[] args) {
        boolean isUseJdkProxy = true;

        if (isUseJdkProxy) {
            System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
            SeckillServiceImpl star = (SeckillServiceImpl) new JdkProxyHandler().proxy(new SeckillServiceImpl());
            star.testAop();
        } else {

            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                    "C:\\Users\\Administrator\\IdeaProjects\\untitled\\cglibClass");

            SeckillServiceImpl star = (SeckillServiceImpl) new CglibProxyHandler().proxy(new SeckillServiceImpl());

            // 这一步里面的具体流程：
            // 动态代理类的sing方法 --> CglibProxyHandler的intercept方法
            //  --> 实际类执行前的行为代理 --> MethodProxy.invokeSuper方法
            //  --> 根据唯一id在FastClass里找到对应的实际方法
            //  --> 代理类的FastClass内部：让代理类调用实际方法
            //  --> 代理类的实际方法内部一般就是直接调用父类(被代理类)的方法
            //  --> 返回父类方法的返回值
            star.testAop();

        }
    }

}
