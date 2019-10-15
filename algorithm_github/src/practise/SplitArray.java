package practise;
/*
* 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
* */
public class SplitArray {
    /*
    dp[i][j]代表在nums[0~i]中分成j+1块的子数组各自和的最大值最小，则显然有：
    dp[i][j] = min{
                max(dp[i-1][j-1],sum[i]-sum[i-1]),这种情况表示nums[i]自成一组
                max(dp[i-2][j-1],sum[i]-sum[i-2]),这种情况表示nums[i]和nums[i-1]一组
                .....
                max(dp[j-1][j-1],sum[i]-sum[j-1],因为前面的要分成j组，所以最少要j个元素，所以只到此
                    }
     由于每个dp[i][j]只于dp[...][j-1]相关，故可以只用两个数组来回倒，不需要开二维数组
     */
    public int splitArray(int[] nums, int m) {
        long[] dp_1 = new long[nums.length];
        long[] dp_2 = new long[nums.length];
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        dp_2[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i]+sum[i-1];
            dp_2[i] = sum[i];
        }
        if (m==1){
            return (int)sum[sum.length-1];
        }
        for (int i = 1; i < m ; i++) {

                long[] temp = dp_1;
                dp_1 = dp_2;
                dp_2 = temp;

            for (int j = i; j <dp_2.length ; j++) {
                dp_2[j]= sum[sum.length-1];
                for (int k = j-1; k >= i-1; k--) {
                    dp_2[j] = Math.min(dp_2[j],Math.max(dp_1[k],sum[j]-sum[k]));
                }
            }
        }
        return (int)dp_2[dp_2.length-1];
    }
}
