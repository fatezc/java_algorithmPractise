package practise;
/*
* 我们正在玩一个猜数游戏，游戏规则如下：

我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。

每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。

然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class GetMoneyAmount {
    //dp[a][b]表示在区间[a~b]中确保猜中一个数字最少需要的现金数
    /*
    则dp[a][b] = Min(a + dp[a+1][b],
                    a+1 + Max(dp[a][a],dp[a+2][b],
                    a+2 + Max(dp[a][a+1],dp[a+3][b]
                    ...
                    b + dp[a][b-1])
     即每次更新dp数组都沿对角线更新即可
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <n+1 ; i++) {
            dp[i][i] = 0;
        }
        int tempmin;
        for(int cur = 1;cur<n;cur++){
            for (int i = 1; i+cur < n+1; i++) {
                tempmin = Integer.MAX_VALUE;
                for (int j = i; j <=i+cur ; j++) {
                    if (j == i)
                        tempmin = Math.min(tempmin,j+dp[i+1][i+cur]);
                    else if (j == i+cur)
                        tempmin = Math.min(tempmin,j+dp[i][i+cur-1]);
                    else tempmin = Math.min(tempmin,j+Math.max(dp[i][j-1],dp[j+1][i+cur]));
                }
                dp[i][i+cur] = tempmin;
            }
        }
        return dp[1][n];
    }
}
