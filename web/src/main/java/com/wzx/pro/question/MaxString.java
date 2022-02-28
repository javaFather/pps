package com.wzx.pro.question;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxString {
    public static Queue solution(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        Queue queue = new LinkedList<>();
        Queue max = new LinkedList();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            while (!queue.contains(c)) {
                queue.offer(c);
                continue;
            }
            if (queue.size() > max.size()) {
                max.clear();
                max.addAll(queue);
                continue;
            }
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
        }
        if (queue.size() > max.size()) {
            max = queue;
        }

        return max;
    }

    public static int solutionReturnInt(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        int max = 1;
        Map<Character, Integer> map = Maps.newHashMap();
        for(int r=0,l=r;r<str.length();r++){
            char c = str.charAt(r);
            Integer repeatIndex = map.get(c);
            if(null != repeatIndex && repeatIndex>=l){
                l = repeatIndex+1;
            }else {
                max = Math.max(max,r-l+1);
            }
            map.put(c,r);
        }
        return max;
    }


    public static int lengthOfLongest(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int max = 1;

        int left = 0;
        while (left < length - 1) {
            int right = left + 1;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            map.put(s.charAt(left), left);
            while (right < length) {
                if (map.get(s.charAt(right)) != null) {
                    break;
                }
                map.put(s.charAt(right), right);
                right++;
            }
            max = Math.max(right - left, max);
            left++;
        }
        return max;
    }


    public static void main(String[] args) {
//        String str = "abcdeacsdfgh";
        String str = "abcabs";
        Queue solution = solution(str);
        int solutionReturnInt = solutionReturnInt(str);
        System.out.println(solution);
        System.out.println(solutionReturnInt);
    }
}
