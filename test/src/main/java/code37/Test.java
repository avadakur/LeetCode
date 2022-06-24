package code37;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/24 15:44
 */
public class Test {
    public static void main(String[] args) {
        new Solution().solveSudoku(new char[][]{});
    }
}

class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    public boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') continue;

                //遍历1-9的数字
                for (int num = 1; num <= 9; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = ((char) num);
                        if(dfs(board)) return true;
                        board[i][j] = '.';
                    }
                }


            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int x, int y, int num) {
        //同一行
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == ((char) num)) {
                return false;
            }
        }
        //同一列
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == ((char) num)) {
                return false;
            }
        }

        //同一个3*3内
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == ((char) num)) {
                    return false;
                }
            }
        }
        return true;
    }
}
