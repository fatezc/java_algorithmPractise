package practise;

import java.util.Arrays;

/*
* 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null ||coins.length == 0)
            return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        for (int i = 0; i < coins.length; i++) {
            if(coins[i]<dp.length)
                dp[coins[i]] = 1;
        }
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == 1)
                continue;
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j]>=1 && dp[i-coins[j]]!=-1){
                    if (dp[i] == -1)
                        dp[i] = dp[i-coins[j]]+1;
                    else dp[i] = dp[i-coins[j]]+1<dp[i]?dp[i-coins[j]]+1:dp[i];
                }
            }
        }
        return dp[amount];
    }
}
