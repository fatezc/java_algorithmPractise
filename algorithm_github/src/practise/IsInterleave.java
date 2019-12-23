package practise;
/*
* 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

示例 1:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
示例 2:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/interleaving-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IsInterleave {
    /*
    dp[i][j]代表s1[i:]和s2[j:]能否交错组成s3[i+j:]
    则if (s1.charAt(i) == s3.charAt(i+j))
                    dp[i][j] = (dp[i][j] || dp[i+1][j]);
      if (s2.charAt(j) == s3.charAt(i+j))
                    dp[i][j] = (dp[i][j] || dp[i][j+1]);
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()==0)
            return s2.compareTo(s3)==0;
        if (s2.length()==0)
            return s1.compareTo(s3)==0;
        if (s1.length() + s2.length() !=s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[dp.length-1][dp[0].length-1] = true;
        for (int i = dp[0].length-2,j = 1; i >=0; i--,j++) {
            if (dp[dp.length - 1][i + 1] && s3.charAt(s3.length()-j)==s2.charAt(s2.length()-j))
                dp[dp.length-1][i] = true;
        }
        for (int i = dp.length-2,j=1;i>=0;i--,j++){
            if (dp[i+1][dp[0].length-1] && s3.charAt(s3.length()-j) == s1.charAt(s1.length()-j))
                dp[i][dp[0].length-1] = true;
        }
        for (int i = dp.length-2; i >=0 ; i--) {
            for (int j = dp[0].length-2; j >=0 ; j--) {
                if (s1.charAt(i) == s3.charAt(i+j))
                    dp[i][j] = (dp[i][j] || dp[i+1][j]);
                if (s2.charAt(j) == s3.charAt(i+j))
                    dp[i][j] = (dp[i][j] || dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
