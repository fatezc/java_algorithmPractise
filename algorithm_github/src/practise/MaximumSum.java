package practise;
/*
* 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。

换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。

注意，删除一个元素后，子数组 不能为空。

请看示例：

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray-sum-with-one-deletion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaximumSum {
    public int maximumSum(int[] arr) {
        int ans = Integer.MIN_VALUE;
        //如果数组全为负，直接返回其中最大的负数
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans,arr[i]);
        }
        if (ans<=0)
            return ans;
        /*
        dp[i][0]表示以每个位置结尾的不删除元素的最大子数组和，dp[i][1]表示以每个位置结尾的删除一个元素的最大子数组和
        当arr[i]>=0时，dp[i][1]直接加上arr[i]即可，当arr[i]<0时，那么就有两种情况：
                                        1.删除arr[i]，即dp[i-1][0]
                                        2.删除dp[i-1][1]中删除的那个数，即dp[i-1][1]+arr[i]
                                        取较大的即可
        而不管arr[i]的正负，dp[i][0]都等于Math.max(dp[0], 0) + arr[i];
        由于每次更新只需要知道前一个的状态，所以用一个int[2]保存dp[i-1]即可
         */
        int[] dp = new int[2];
        dp[0] = arr[0];
        dp[1] = 0;
        ans = Math.max(dp[0],dp[1]);
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]>=0)
                dp[1] = dp[1] + arr[i];
            else dp[1] = Math.max(dp[0],dp[1]+arr[i]);
            dp[0] = Math.max(dp[0], 0) + arr[i];
            ans = Math.max(ans,Math.max(dp[0],dp[1]));
        }
        return ans;
    }
}
