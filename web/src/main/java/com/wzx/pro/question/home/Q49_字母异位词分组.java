package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

public class Q49_字母异位词分组 {
    private static List<List<String>> solution(String[] strs){
        List<List<String>> result = new ArrayList<>(strs.length);
        Map<String,Integer> map = Maps.newHashMap();
        for(int i=0;i< strs.length;i++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key  = new String(chars);
            Integer integer = map.get(key);
            if(Objects.nonNull(integer)){
                List<String> strings = result.get(integer);
                strings.add(str);
                result.set(integer,strings);
            }else {
                List<String> item = Lists.newArrayList();
                item.add(str);
                result.add(item);
                map.put(key,result.size()-1);
            }

        }

        return result;
    }

    public static void main(String[] args) {
      String[]  strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> solution = solution(strs);
        System.out.println(JSON.toJSONString(solution));


    }
}
