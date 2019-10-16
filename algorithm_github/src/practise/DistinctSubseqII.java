package practise;


import java.util.HashMap;

/*
* 给定一个字符串 S，计算 S 的不同非空子序列的个数。

因为结果可能很大，所以返回答案模 10^9 + 7.
* */
public class DistinctSubseqII {
    //dp[i]用来记录以i位置结尾的不同序列数,sum[i]表示dp[0~i-1]的和
    public int distinctSubseqII(String S) {
        int[] dp = new int[S.length()];
        int[] sum = new int[dp.length+1];
        int mod = 1_000_000_007;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < dp.length; i++) {
            if (map.containsKey(S.charAt(i))){
                int help = map.get(S.charAt(i));
                dp[i] = (sum[i]+mod -sum[help])%mod;
            }else {
                dp[i] = (1+sum[i])%mod;
            }
            sum[i+1] = (sum[i]+dp[i])%mod;
            map.put(S.charAt(i),i);
        }
        return sum[dp.length];
    }

}
