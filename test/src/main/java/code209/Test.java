package code209;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/21 10:59
 */
public class Test {
    public static void main(String[] args) {

        int i = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (left <= right && right < nums.length && left < nums.length) {
            while (right<nums.length &&  sum < target){
                sum += nums[right++];
            }
            while (left < nums.length && sum >= target){
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min;
    }
}
