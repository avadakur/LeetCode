package code40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/23 13:41
 */
public class Test {
    public static void main(String[] args) {
        new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        dfs(target, candidates, 0);
        return res;
    }

    public void dfs(int target, int[] candidates, int startIndex) {
        if (target <= 0) {
            if(target == 0) res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {

                continue;
            }
            used[i] = true;
            path.add(candidates[i]);
            dfs(target - candidates[i], candidates, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }

    }
}
