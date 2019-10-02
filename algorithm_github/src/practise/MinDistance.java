package practise;
/*
* 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
* */
//采用dp,dp[m][n]表示word1[0~m]和word2[0~n]的最长相同自序列
public class MinDistance {
    public int minDistance(String word1, String word2) {
        if (word1==null||word1.length()==0)
            return word2.length();
        if (word2==null||word2.length()==0)
            return word1.length();
        int[][] dp = new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0)?1:0;
        for (int i = 1; i < word1.length(); i++) {
            if (dp[i-1][0] == 1||word1.charAt(i) == word2.charAt(0))
                dp[i][0] = 1;
        }
        for (int i = 1; i < word2.length(); i++) {
            if (dp[0][i-1] == 1||word1.charAt(0) == word2.charAt(i))
                dp[0][i] =1;
        }
        for (int i = 1; i <word1.length() ; i++) {
            for (int j = 1; j <word2.length() ; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return word1.length()+word2.length()-2*dp[word1.length()-1][word2.length()-1];
    }
}
