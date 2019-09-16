package practise;
/*
* 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class DifferentPath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null||obstacleGrid.length == 0||obstacleGrid[0].length == 0)
            return 0;
       int m = obstacleGrid.length,n = obstacleGrid[0].length;
       if (obstacleGrid[m-1][n-1]==1)
           return 0;
       int[][] dp = new int[m][n];
       dp[m-1][n-1] = 1;
        for (int i = m-2; i >=0 ; i--) {
            if (dp[i+1][n-1] == 1&&obstacleGrid[i][n-1] == 0)
                dp[i][n-1] = 1;
        }
        for (int i = n-2;i>=0;--i){
            if (dp[m-1][i+1] == 1&& obstacleGrid[m-1][i] == 0)
                dp[m-1][i] =1;
        }
        for (int i = m-2; i >=0 ; i--) {
            for (int j = n-2; j >=0 ; j--) {
                if (obstacleGrid[i][j] == 0)
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
