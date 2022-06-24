package codee90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/24 9:21
 */
public class Test {
    public static void main(String[] args) {
        new Solution().subsetsWithDup(new int[]{1, 2, 2});
    }
}


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums);
        return res;
    }


    public void dfs(int startIndex, int[] nums) {
        if(startIndex > nums.length){
            return;
        }
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(i + 1, nums);
            path.remove(path.size() - 1);

        }

    }
}
