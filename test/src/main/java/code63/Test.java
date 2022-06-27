package code63;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/27 14:47
 */
public class Test {
    public static void main(String[] args) {
        new Solution().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] = 1;

        boolean flag = false;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] == 1) flag = true;
            dp[i][0] = flag ? 0 : 1;
        }
        flag = false;

        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] == 1) flag = true;
            dp[0][i] = flag ? 0 : 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j]) + (obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
