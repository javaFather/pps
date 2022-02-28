package com.wzx.pro.question;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class Q17_c {
    public static List<String> solution(String str) {
        List<String> result = Lists.newArrayList();
        if (str.length() < 1) {
            return result;
        }
        Map<Character, String> map = Maps.newHashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        convert(str,map,result,0,"");
        return result;
    }

    public static void convert(String str,Map<Character,String> map,List<String> result,int index,String item){
        if(index==str.length()){
            result.add(item);
            return;
        }
        char c = str.charAt(index);
        String s = map.get(c);
        for(int i =0;i<s.length();i++){
            char c2 = s.charAt(i);
            convert(str,map,result,index+1,item+c2);
        }
    }

    public static void main(String[] args) {
        String str   ="23";
        List<String> solution = solution(str);
        System.out.println(solution);
    }
}
