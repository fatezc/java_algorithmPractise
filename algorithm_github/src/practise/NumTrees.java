package practise;
/*
* 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
* */
public class NumTrees {
    /*
    对于dp[n]，遍历每个数字i,i属于[1,n]，以i作为根节点的二叉搜索树有dp[i-1]*dp[n-(i-1)]种
     */
    public int numTrees(int n) {
        int[] dp = new int[Math.max(n+1,2)];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <dp.length ; i++) {
            int count = 0;
            for (int j = 0; j<i ; j++) {
                count += dp[j]*dp[i-1-j];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
