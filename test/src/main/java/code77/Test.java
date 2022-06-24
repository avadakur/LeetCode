package code77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/23 9:26
 */
public class Test {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        dfs(k, n, 1);
        return res;
    }

    public static void dfs(int k,int n,int start){
        if (path.size() >= k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(k, n, start + 1);
            path.remove(path.size() - 1);
        }
    }
}
