package com.wzx.pro.question;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class Q3_c {
    public static int solution(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        int result = 1;
        Map<Character, Integer> map = Maps.newHashMap();
        int repeatIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer oldIndex = map.get(c);
            if (null != oldIndex && repeatIndex <= oldIndex) {
                repeatIndex = oldIndex + 1;
            } else {
                result = Math.max(result, i - repeatIndex + 1);
            }
            map.put(c, i);

        }
        return result;
    }
}
