package practise;
/*
* 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distinct-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumDistinct {
    //动态规划，dp[i][j]表示s[0~i]子序列中t[0~j]出现的个数
    //dp[i][0]都初始化为1，是用来表示对应所有s[0~i]都包含一个空字符串
    //由于每一行都只取决于上一行，所以空间可以再优化，常规操作，不写了
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i<j)
                    continue;
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}
