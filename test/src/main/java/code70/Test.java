package code70;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/27 9:31
 */
public class Test {
    public static void main(String[] args) {

    }
}

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if(n <= 1) return 1;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
