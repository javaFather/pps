package com.wzx.pro.interview;

import java.util.HashMap;
import java.util.Map;

public class wl_1 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max =0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char item = s.charAt(i);
            if(map.get(item)!=null){
                if(left<=map.get(item)){
                    left = map.get(item)+1;
                }
            }
            map.put(item,i);
            max = Math.max(max,i-left+1);

        }

        return max;
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
      for(int i=0;i<10;i++){
          map.put(i,i);
          if(map.get(i)!=null){
              System.out.println("++++++++++++++++++++");
          }
          if(map.containsKey(i)){
              System.out.println("==================");
          }

      }

    }
}
