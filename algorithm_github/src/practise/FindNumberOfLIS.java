package practise;
/*
* 给定一个未排序的整数数组，找到最长递增子序列的个数
* */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null ||nums.length == 0)
            return 0;
        int[][]dp = new int[nums.length][2];
        dp[0][0] = 1;//dp[i][0]表示以i结尾的最长子序列长度
        dp[0][1] = 1;//dp[i][1]表示最长自序列个数
        //找到以每个元素为结尾的最长子序列长度和相应的个数
        for (int i = 1; i <dp.length ; i++) {
            int maxlen = 0,sum=1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    if(dp[j][0]>maxlen)  {
                        sum = dp[j][1];
                        maxlen = dp[j][0];
                    }else if (dp[j][0] == maxlen){
                        sum += dp[j][1];
                    }
                }
            }
            dp[i][0] = maxlen+1;
            dp[i][1] = sum;
        }
        //找出dp中的最长自序列长度并返回相应的个数和
        int ans = 0,max_cur = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0]>max_cur){
                max_cur = dp[i][0];
                ans = dp[i][1];
            }else if (dp[i][0] == max_cur)
                ans += dp[i][1];
        }
        return ans;
    }
}
