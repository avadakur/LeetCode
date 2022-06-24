package code51;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChenjieLu
 * @description
 * @date 2022/6/24 14:57
 */
public class Test {
    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
}

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] chars : chessBoard) {
            Arrays.fill(chars, '.');
        }
        dfs(0, n, chessBoard);
        return res;
    }

    public void dfs(int row, int n, char[][] chessBoard) {
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (char[] chars : chessBoard) {
                String t = new String(chars);
                l.add(t);
            }
            res.add(l);
            return;
        }

        for (int i = 0; i < chessBoard.length; i++) {
            if (isValid(row,i,chessBoard,n)) {
                chessBoard[row][i] ='Q';
                dfs(row + 1, n, chessBoard);
                chessBoard[row][i] = '.';
            }
        }
    }

    public boolean isValid(int row, int column, char[][] chessBoard, int n) {
        //检查同一行
        for (int i = 0; i < chessBoard.length; i++) {
            if (chessBoard[row][i] == 'Q') {
                return false;
            }
        }
        //检查同一列
        for (int i = 0; i < chessBoard.length; i++) {
            if(chessBoard[i][column] == 'Q')
                return false;
        }
        //检查斜对角线
        int x = row;
        int y = column;
        while (x >= 0 && x < chessBoard.length && y >= 0 && y < chessBoard.length) {
            if (chessBoard[x][y] == 'Q') {
                return false;
            }
            x++;
            y++;
        }
        x = row;
        y = column;
        while (x >= 0 && x < chessBoard.length && y >= 0 && y < chessBoard.length) {
            if (chessBoard[x][y] == 'Q') {
                return false;
            }
            x--;
            y--;
        }
        x = row;
        y = column;
        while (x >= 0 && x < chessBoard.length && y >= 0 && y < chessBoard.length) {
            if (chessBoard[x][y] == 'Q') {
                return false;
            }
            x--;
            y++;
        }
        x = row;
        y = column;
        while (x >= 0 && x < chessBoard.length && y >= 0 && y < chessBoard.length) {
            if (chessBoard[x][y] == 'Q') {
                return false;
            }
            x++;
            y--;
        }

        return true;
    }
}
