package practise;
/*
* 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。

我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。

如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumRollsToTarget {
    //动归：每到下一个骰子，dp[i]更新为dp[i-f]+...+dp[i-1]
    public int numRollsToTarget(int d, int f, int target) {
        int[] dp = new int[target];
        int mod = 1_000_000_007;
        for (int i = 0; i < f; i++) {
            if (i<dp.length)
            dp[i] = 1;
        }
        int temp;
        for (int i = 0; i < d; i++) {
            for (int j = dp.length-1; j >=0 ; j--) {
                temp = 0;
                for (int k = 1; k <=f ; k++) {
                    if (j-k<0)
                        break;
                    temp += dp[j-k];
                    temp %= mod;
                }
                dp[j] = temp;
            }
        }
        return dp[target-1];
    }
}
