package com.wzx.pro.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wzx.pro.domain.product.Product;

import java.util.List;

/**
 * @author wangzhenxing
 * @description
 * @date 2021/6/11 15:24
 */
public class ThreadLocalTest {
    private List<String> messages = Lists.newArrayList();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(Product product) {
        holder.get().messages.add(JSON.toJSONString(product));
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();
        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        Product product = new Product();
        product.setProductCode("1234");
        product.setProductName("测试1234");
        product.setProductPrice("12.10");
        product.setProductType("360JR");
        ThreadLocalTest.add(product);
        System.out.println(holder.get().messages);
        ThreadLocalTest.clear();
    }
}
