package practise;
/*
* 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
示例 1：

输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
输出：9
示例 2：

输入：grid = [[1,1,0,0]]
输出：1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-1-bordered-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        //dp[i][j][0]记录每个点朝上最多有多少个连着的1，dp[i][j][1]记录朝左最多有多少个连着的1，如示例1：dp[2][2][0] = 3,dp[2][2][1] = 3
        int[][][] dp = new int[grid.length][grid[0].length][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
               dp[i][j][0] = i-1>=0?dp[i-1][j][0]+1:1;
               dp[i][j][1] = j-1>=0?dp[i][j-1][1]+1:1;
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (Math.min(dp[i][j][0],dp[i][j][1])<=ans)
                    continue;
                //对于每一个可能改变ans的点，将它作为正方形的右下角的端点,检查正方形的另外两条边
                for (int help = Math.min(dp[i][j][0],dp[i][j][1]);help>=ans;help--){
                   if (dp[i][j-help+1][0] >= help && dp[i-help+1][j][1]>=help){
                       ans = help;
                       break;
                   }
                }
            }
        }
        return ans;
    }
}
