package com.wzx.pro.interview;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q_5 {
    public static String longestPalindrome(String s) {
        int length = s.length();
        if(length<2){
            return s;
        }
        int maxLength = 0;
        int startIndex =0;
        boolean[][] dp = new boolean[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=true;
        }
        char[] charArray = s.toCharArray();

        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(charArray[i]==charArray[j]){
                    if(j-i<2){
                        dp[i][j]=true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else{
                    dp[i][j]=false;
                }
                if(dp[i][j]){
                    if(j-i+1>maxLength){
                        maxLength=j-i+1;
                        startIndex=i;
                    }
                }

            }
        }
        return s.substring(startIndex,startIndex+maxLength);

    }

    public static void main(String[] args) {

        int[] a = {3,2,3,1,2,4,5,5,6};
        int kthLargest = findKthLargest(a,4);

    }

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(10);
        queue.offer(5);
        if(queue.size()>2){
            queue.poll();
        }
        queue.offer(3);
        if(queue.size()>2){
            queue.poll();
        }
        queue.offer(2);
        if(queue.size()>2){
            queue.poll();
        }
        return 0;
    }
}
