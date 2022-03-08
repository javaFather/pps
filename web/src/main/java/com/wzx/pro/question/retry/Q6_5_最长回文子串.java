package com.wzx.pro.question.retry;

public class Q6_5_最长回文子串 {

    private static String solution(String str) {

        if(str.length()<2){
            return str;
        }

        int length = str.length();
        boolean[][] dp = new boolean[length][length];
        for (int i =0;i<length;i++){
            dp[i][i] = true;
        }
        int max = 1;
        int left = 0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(str.charAt(i) == str.charAt(j)){
                    if(j-i<=2){
                        dp[i][j] =true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if(j-i+1>max){
                        max = j-i+1;
                        left = i;
                    }

                }

            }
        }



        return str.substring(left,left+max);
    }


    public static void main(String[] args) {
//        String str = "一个上海自来水来自海上的故事";
        String str = "啊";
        String solution = solution(str);
        System.out.println(solution);
    }

}
