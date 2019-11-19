package practise;
/*
* 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。

注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-sum-of-averages
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class LargestSumOfAverages {
    /*
    dp[i][j]表示A[0~i]分成j个子数组的平均和，则dp[i][j] = max(
                                                            dp[i-1][j-1] + A[i],
                                                            dp[i-2][j-1] + (A[i]+A[i-1])/2
                                                            ...
                                                            dp[j-1][j-1] + Avg(A[i]~A[j]))
     下面是用一维动态数组的解法
     */
    public double largestSumOfAverages(int[] A, int K) {
        int[] sum = new int[A.length+1];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i-1] + A[i];
        }
        double[] dp = new double[A.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = sum[i]*1.0/(i+1);
        }
        for (int i = 1; i <K ; i++) {
            for (int j = dp.length-1; j >=i ; j--) {
                dp[j] = 0;
                for (int k = j-1; k >=i-1 ; k--) {
                    dp[j] = Math.max(dp[j],dp[k]+(sum[j]-sum[k])*1.0/(j-k));
                }
            }
        }
        return dp[dp.length-1];
    }
}
