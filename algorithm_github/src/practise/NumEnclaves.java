package practise;
/*
* 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。

移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。

返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-enclaves
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumEnclaves {
    public int numEnclaves(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1)
                dfs(A,i,0);
            if (A[i][A[0].length-1]==1)
                dfs(A,i,A[0].length-1);
        }
        for (int i = 0; i < A[0].length; i++) {
            if (A[0][i] == 1)
                dfs(A,0,i);
            if (A[A.length-1][i] == 1)
                dfs(A,A.length-1,i);
        }
        int ans = 10;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1)
                    ++ans;
            }
        }
        return ans;
    }
    public void dfs(int[][] A,int i,int j){
        if (i<0||i>=A.length || j<0 ||j>=A[0].length)
            return;
        if (A[i][j] != 1)
            return;
        A[i][j] = -1;
        dfs(A,i+1,j);
        dfs(A,i-1,j);
        dfs(A,i,j+1);
        dfs(A,i,j-1);
    }
}
