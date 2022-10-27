package com.example.myapplication.剑指offer.算法思想.动态规划;


// https://github.com/CyC2018/CS-Notes/blob/master/notes/47.%20%E7%A4%BC%E7%89%A9%E7%9A%84%E6%9C%80%E5%A4%A7%E4%BB%B7%E5%80%BC.md
// https://blog.csdn.net/qq_45287265/article/details/111779793
public class 礼物的最大价值 {

    public int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }

        int dp[][] = new int[values.length + 1][values[0].length + 1];
        for (int i = 1; i <= values.length ; i++) {
            for (int j = 1; j <= values.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]) + values[i- 1][j - 1];
            }
        }
        return dp[values.length][values[0].length];
    }
}
