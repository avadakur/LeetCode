package code746;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/27 9:36
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        dp[cost.length] = Math.min(dp[cost.length - 1], dp[cost.length - 2]);
        return dp[cost.length];
    }
}

