package code491;

import java.util.*;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/24 9:33
 */
public class Test {
    public static void main(String[] args) {
        new Solution().findSubsequences(new int[]{1, 3, 2, 2});
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, nums);
        return res;
    }

    public void dfs(int startIndex, int[] nums) {
        if (startIndex > nums.length) {
            return;
        }
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> tmpSet = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (path.isEmpty() || (i > 0 && path.get(path.size() - 1) <= nums[i]) && !tmpSet.contains(nums[i])) {
                tmpSet.add(nums[i]);
                path.add(nums[i]);
            } else {
                continue;
            }
            dfs(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

}

