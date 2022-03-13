package com.wzx.pro.question.tik;

public class Q18_459_重复的子字符串 {

    private static boolean solution(String str) {
        int count = str.length() / 2;
        int length = str.length();

        for (int i = 1; i <= count; i++) {
            String item = str.substring(0, i);
            int len = item.length();
            if (length % len != 0) {
                continue;
            }
            int index = i;
            int sum = 0;
            while (index<length){
                String obj = str.substring(index,index+i);
                index = index+i;
                if(obj.equals(item)){
                    sum++;
                }else {
                    break;
                }
            }
            if(sum == (length/len)-1){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String str = "abaababaab";
        boolean solution = solution(str);
        System.out.println(solution);
    }
}
