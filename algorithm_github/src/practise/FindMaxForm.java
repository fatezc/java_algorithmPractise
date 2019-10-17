package practise;
/*
* 在计算机界中，我们总是追求用有限的资源获取最大的收益。

现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。

你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。

注意:

给定 0 和 1 的数量都不会超过 100。
给定字符串数组的长度不会超过 600。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ones-and-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class FindMaxForm {
    //二维背包问题，每次循环中的dp[i][j]表示到目前这个字符串为止，i个1和j个0能获得的最大收益
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int ones = 0,zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0')
                    zeros++;
                else ones++;
            }
            for (int i = m; i >=ones ; i--) {
                for (int j = n; j >= zeros; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-ones][j-zeros]+1);
                }
            }
        }
        return dp[m][n];
    }
}
