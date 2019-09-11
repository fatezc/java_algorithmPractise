package practise;
/*
* 给定一个无序的整数数组，找到其中最长上升子序列的长度。
* */
public class LongestSubList {
    //dp[i]表示必须以nums[i]结尾的最长子序列个数
    public int lengthOfLIS(int[] nums) {
        if (nums == null||nums.length == 0)
            return 0;
        if (nums.length==1)
            return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i <dp.length ; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
