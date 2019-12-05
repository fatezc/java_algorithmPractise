package practise;
/*
* 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
* */
public class NumMatrix {
    private int[][] dp;
    //dp[i][j]表示matrix[0,0]到[i-1,j-1]的子矩阵和
    public NumMatrix(int[][] matrix) {
        if (matrix.length==0)
            dp = new int[1][1];
        else {
            dp = new int[matrix.length+1][matrix[0].length+1];
            for (int i = 1; i <dp.length ; i++) {
                for (int j = 1; j <dp[0].length ; j++) {
                    dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp.length==1)
            return 0;
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}
