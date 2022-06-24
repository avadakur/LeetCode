package code59;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/21 13:07
 */
public class Test {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        System.out.println(ints);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int target = n * n;

        int start = 1;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (start <= target) {
            for (int i = left; i <= right; i++) {
                res[top][i] = start++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = start++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = start++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = start++;
            }
            left++;

        }
        return res;

    }
}
