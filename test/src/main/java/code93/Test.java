package code93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/23 17:22
 */
public class Test {
    public static void main(String[] args) {

    }
}

class Solution {
    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        return null;
    }


    public void dfs() {
        if (path.size() == 4) {
            String temp = "";
            for (String t : path) {
                temp += t;
            }
            res.add(temp);
        }


    }
}
