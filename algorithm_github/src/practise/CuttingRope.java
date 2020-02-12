package practise;
/*
* 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m≥1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CuttingRope {
    public int cuttingRope(int n) {
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i+1;
        }
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = dp.length-1; j >i ; j--) {
                dp[j] = 0;
                for (int k = 1; j-k >=i ; k++) {
                    dp[j] = Math.max(dp[j],k*dp[j-k]);
                }
                ans = Math.max(ans,dp[j]);
            }
        }
        return ans;
    }
}
