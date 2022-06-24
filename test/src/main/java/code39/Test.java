package code39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/23 13:07
 */
public class Test {
    public static void main(String[] args) {
        new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}


class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(target, candidates, 0);
        return res;
    }

    public void dfs(int target, int[] candidates, int startIndex) {
        if (target <= 0) {
            if(target == 0) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if(target - candidates[i] < 0) break;
            path.add(candidates[i]);
            dfs(target - candidates[i], candidates, i);
            path.remove(path.size() - 1);
        }
    }

}