package practise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
* 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
* 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。

注意：本题相对原题做了扩展
* */
public class SolveNQueens {
    private char[][] help ;
    public List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
           help = new char[n][n];
           ans = new LinkedList<>();
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help.length; j++) {
                help[i][j] = '.';
            }
        }
        backtrack(0);
        return ans;
    }
    public void backtrack(int n){
        if (n == help.length){
            LinkedList<String> strings = new LinkedList<>();
            for (int i = 0; i < help.length; i++) {
                strings.add(String.valueOf(help[i]));
            }
            ans.add(strings);
            return;
        }
        for (int i = 0; i < help.length; i++) {
            if (judge(n,i)){
                help[n][i] ='Q';
                backtrack(n+1);
                help[n][i] ='.';
            }
        }
    }
    public boolean judge(int row,int col){
        for (int i = 0; i < row; i++) {
            if (help[i][col] == 'Q')
                return false;
        }
        for (int i = 0; i < col; i++) {
            if (help[row][i] == 'Q')
                return false;
        }
        for (int i = 0; i < row; i++) {
            if (row+col-i<help.length && help[i][row+col-i] == 'Q')
                return false;
            if (i-row+col>=0&&help[i][i-row+col] == 'Q')
                return false;
        }
        return true;
    }
}
