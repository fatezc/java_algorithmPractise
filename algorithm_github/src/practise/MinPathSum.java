package practise;
/*
* 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
* */
public class MinPathSum {
    //一维dp
    public int minPathSum(int[][] grid) {
        if (grid.length==0||grid[0].length == 0)
            return 0;
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            if (i==0)
                dp[i] = grid[0][i];
            else dp[i] = grid[0][i]+dp[i-1];
        }
        for (int i = 1; i <grid.length ; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j == 0)
                    dp[j] = dp[j]+grid[i][j];
                else dp[j] = Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[dp.length-1];
    }
}
