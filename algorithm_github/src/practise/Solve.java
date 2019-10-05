package practise;
/*
* 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
* 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Solve {
    public void solve(char[][] board) {
        if (board==null||board.length==0)
            return;
        for (int i = 0; i < board.length; i++) {
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board,0,i);
            dfs(board,board.length-1,i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*')
                    board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
        return;
    }
    //把四条边dfs,将不填充的'O'用'*'标记
    public void dfs(char[][] board,int i ,int j ){
        if (i<0||j<0||i>=board.length||j>=board[0].length)
            return;
        if (board[i][j] == 'X'||board[i][j] == '*')
            return;
        if (board[i][j] == 'O'){
            board[i][j] = '*';
            dfs(board,i+1,j);
            dfs(board,i-1,j);
            dfs(board,i,j+1);
            dfs(board,i,j-1);
        }
    }
}
