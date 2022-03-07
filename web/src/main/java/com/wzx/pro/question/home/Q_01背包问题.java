package com.wzx.pro.question.home;

public class Q_01背包问题 {

    //五个商品
    static int n = 5;
    //容量是10 的背包
    static int c = 10;
    //五个商品分别对应的重量和 价值
    static int[] w = {0, 2, 2, 6, 5, 4};
    static int[] v = {0, 6, 3, 5, 4, 6};

    /**
     * 二维数组解法
     * @return
     */
    private static int solution() {
        int[][] dp = new int[6][11];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = dp[i-1][j];
                //当前i商品可以被放下
                if(j-w[i]>=0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }

        }


        return dp[n][c];
    }


    private static int solution2(){
        int[] dp = new int[c+1];
        for(int i=1;i<=n;i++){
            for(int j=c;j>=w[i];j--){
                if(dp[j]<dp[j-w[i]]+v[i]){
                    dp[j] = dp[j-w[i]]+v[i];
                }
            }
        }


        return dp[c];
    }


    public static void main(String[] args) {
        int solution = solution();
        int solution2 = solution2();
        System.out.println(solution);
        System.out.println(solution2);
    }
}
