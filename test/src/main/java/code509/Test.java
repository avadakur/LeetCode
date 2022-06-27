package code509;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/27 9:26
 */
public class Test {
    public static void main(String[] args) {

    }
}

class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}


