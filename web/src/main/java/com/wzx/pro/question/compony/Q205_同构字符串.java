package com.wzx.pro.question.compony;

public class Q205_同构字符串 {

    private static boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        int[] sArray = new int[128];
        int[] tArray = new int[128];
        for (int i = 0; i < len; i++) {
            int sData = s.charAt(i);
            int tData = t.charAt(i);
            if(sArray[sData]!=tArray[tData]){
                return false;
            }
            sArray[sData] = i+1;
            tArray[tData] = i+1;
        }
        return true;

    }


    public static void main(String[] args) {
        boolean solution = solution("adda", "caac");
        System.out.println(solution);
    }


}
