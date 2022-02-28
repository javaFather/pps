package com.wzx.pro.question.home;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Q76 {

    public static Queue solution(String str, String target) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        char[] tarChars = target.toCharArray();
        Queue queue = new LinkedList<>();
        Queue min = new LinkedList();
        Map<Character, Integer> sourMap = Maps.newHashMap();
        Map<Character, Integer> tarMap = Maps.newHashMap();
        for (char ar : tarChars) {
            tarMap.put(ar, tarMap.get(ar) == null ? 1 : tarMap.get(ar) + 1);
        }

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            sourMap.put(c, sourMap.get(c) == null ? 1 : sourMap.get(c) + 1);
            queue.offer(c);

            boolean result = true;
            for (Map.Entry<Character, Integer> entry : tarMap.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if (Objects.nonNull(sourMap.get(key)) && value <= sourMap.get(key)) {
                    continue;
                }
                result = false;
                break;
            }

            //目标串在queue中
            while (result) {
                Character peek = (Character) queue.peek();
                if (Objects.nonNull(tarMap.get(peek)) && sourMap.get(peek) <= tarMap.get(peek)) {
                    result = false;
                }
                queue.poll();
                sourMap.put(peek, sourMap.get(peek) - 1);
                if(result){
                    if (min.size() == 0 || (min.size() > 0 && min.size() > queue.size())) {
                        min.clear();
                        min.addAll(queue);
                    }
                }

            }

        }


        return min;
    }

    public static String solutionString(String str, String target) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        char[] tarChars = target.toCharArray();
        Map<Character, Integer> sourMap = Maps.newHashMap();
        Map<Character, Integer> tarMap = Maps.newHashMap();
        for (char ar : tarChars) {
            tarMap.put(ar, tarMap.get(ar) == null ? 1 : tarMap.get(ar) + 1);
        }

        int include = 0;
        int min = str.length();
        String result = "";
        for (int i = 0, j = 0; i < length; i++) {
            char c = str.charAt(i);
            sourMap.put(c, sourMap.getOrDefault(c, 0) + 1);
            if (tarMap.containsKey(c) && tarMap.get(c) >= sourMap.get(c)) {
                include++;
            }
            char charJ = str.charAt(j);

            //t中的所有元素个数都在窗口中
            if(tarChars.length == include){
                while (j < i && (!tarMap.containsKey(charJ)) || tarMap.get(charJ) < sourMap.get(charJ)){
                    j++;
                    sourMap.put(charJ, sourMap.getOrDefault(sourMap.get(charJ), 0) + 1);

                }
                if (min > i - j + 1) {
                    min = i - j + 1;
                    result = str.substring(j, i - j + 1);
                }
            }

        }
        return result;

    }


    public static void main(String[] args) {
        String str = "AC1BABC";
        String tar = "ABC";
        Queue solutionString = solution(str, tar);
        System.out.println(JSON.toJSONString(solutionString));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> hs = Maps.newHashMap();
        HashMap<Character, Integer> ht = Maps.newHashMap();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        int len = 0x3f3f3f3f, cnt = 0;  //有多少个元素符合
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hs.put(c, hs.getOrDefault(c, 0) + 1);
            if (ht.containsKey(c) && hs.get(c) <= ht.get(s.charAt(i))) {
                cnt++;
            }
            char c1 = s.charAt(j);
            while (j < i && (!ht.containsKey(c1) || hs.get(c1) > ht.get(c1))) {
                int count = hs.get(c1) - 1;
                hs.put(c1, count);
                j++;
            }
            if (cnt == t.length() && i - j + 1 < len) {
                len = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }

    public static String minWindows(String s, String t) {
        //把t中的字符全部放到map中
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int left = 0;//窗口的左边界
        int right = 0;//窗口的右边界

        //满足条件的窗口开始位置
        int strStart = 0;
        //满足条件的窗口的长度
        int windowLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            //记录右指针扫描过的字符
            char rightChar = s.charAt(right);
            //如果右指针扫描的字符存在于map中，就减1
            if (map.containsKey(rightChar))
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
            //记录之后右指针要往右移
            right++;

            //检查窗口是否把t中字符全部覆盖了，如果覆盖了，要移动窗口的左边界
            //找到最小的能全部覆盖的窗口
            while (check(map)) {
                //如果现在窗口比之前保存的还要小，就更新窗口的长度
                //以及窗口的起始位置
                if (right - left < windowLength) {
                    windowLength = right - left;
                    strStart = left;
                }
                //移除窗口最左边的元素，也就是缩小窗口
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar))
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                //左指针往右移
                left++;
            }
        }
        //如果找到合适的窗口就截取，否则就返回空
        if (windowLength != Integer.MAX_VALUE)
            return s.substring(strStart, strStart + windowLength);
        return "";
    }

    //检查窗口是否把字符串t中的所有字符都覆盖了，如果map中所有
// value的值都不大于0，则表示全部覆盖
    private static boolean check(Map<Character, Integer> map) {
        for (int value : map.values()) {
            //注意这里的value是可以为负数的，为负数的情况就是，相同的字符右
            // 指针扫描的要比t中的多，比如t是"ABC"，窗口中的字符是"ABBC"
            if (value > 0)
                return false;
        }
        return true;
    }
}
