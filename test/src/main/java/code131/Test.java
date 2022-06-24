package code131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/23 16:33
 */
public class Test {
    public static void main(String[] args) {
        new Solution().partition("aab");
    }
}

class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<List<String>> partition(String s) {
        dfs(0, s);
        System.out.println(res);
        return res;
    }


    public void dfs(int startIndex, String s) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            System.out.println("startIndex--:"+startIndex);
            System.out.println("i-----------:"+i);
            if (isOaO(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            dfs(i + 1, s);
            path.remove(path.size() - 1);
        }

    }


    public boolean isOaO(String str, int start, int end) {
        while (start < end) {
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
