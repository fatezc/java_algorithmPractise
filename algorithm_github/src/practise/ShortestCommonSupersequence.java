package practise;
/*
* 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。

（如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-common-supersequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ShortestCommonSupersequence {
    //只需要求出最长公共自序列即可
    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1==null||str1.length()==0)
            return str2;
        if (str2==null||str2.length()==0)
            return str1;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = dp.length-1,j = dp[0].length-1;
        //注意根据dp矩阵来求ans时if的顺序，如果把最后一个else放前面就会错,
        // 因为如果先判断dp[i][j] == dp[i-1][j-1]+1，可能str1[i]!=str2[j]时也满足dp[i][j] == dp[i-1][j-1]+1，所以把它放最后，这样就必然str1[i]==str2[j]
        while (i>0||j>0){
            if (i>0&&dp[i][j] == dp[i-1][j]){
                ans.append(str1.charAt(i-1));
                i--;
            }else if(j>0&&dp[i][j] == dp[i][j-1]) {
                ans.append(str2.charAt(j-1));
                --j;
            }else if (i>0&&j>0&&dp[i][j] == dp[i-1][j-1]+1){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }
        }
        char[] res = ans.toString().toCharArray();
        for (int k = 0; k < res.length/2; k++) {
            char ch = res[k];
            res[k] = res[res.length-1-k];
            res[res.length-1-k] = ch;
        }
        return String.valueOf(res);
    }
}
