package com.wzx.pro.question;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class LargeNumber {

    public static String getLargeNumber(int[] arrays) {
        List<String> list = Lists.newArrayList();
        for (int str : arrays) {
            list.add(str + "");
        }
        list.sort((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            log.info(str2+"===="+str1 +"****"+str2.compareTo(str1));
            return str2.compareTo(str1);
        });
        StringBuilder res = new StringBuilder();
        for (String str : list) {
            res.append(str);
            if (res.charAt(0) == '0') {
                return "0";
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 5,3,4,6,7,8,9,10};
        String largeNumber = getLargeNumber(arrays);
        System.out.println(largeNumber);
    }
}
