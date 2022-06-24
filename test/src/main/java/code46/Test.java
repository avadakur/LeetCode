package code46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/24 13:23
 */
public class Test {
    public static void main(String[] args) {
        new Solution().permute(new int[]{1, 2, 3});
    }
}


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs( nums);
        return res;
    }

    public void dfs(int[] nums) {
        if (path.size() >= nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}