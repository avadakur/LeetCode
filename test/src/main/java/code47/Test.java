package code47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/24 13:54
 */
public class Test {
    public static void main(String[] args) {
        new Solution().permuteUnique(new int[]{1,1,2});
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }

    public void dfs(int[] nums) {
        if (path.size() >= nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && !used[i] && nums[i] == nums[i - 1])) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums);
            used[i] = false;
            path.remove(path.size() - 1);
        }

    }


}
