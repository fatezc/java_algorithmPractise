package practise;
/*
* 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
数组的长度不会超过20，并且数组中的值全为正数。
初始的数组的和不会超过1000。
保证返回的最终结果为32位整数
* 解法:dp[i][k] = dp[i-1][k-nums][i]]+dp[i-1][k+nums[i]]
*       dp[i][k]表示用nums[0~i]来组成k的方法数,由于每次只与前一行相关,故可以两个一维数组滚动更新
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/target-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class findSumWays {
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum<Math.abs(S))
            return 0;
        int len = sum + Math.abs(S);
        int A[] = new int[2 * len + 1];//数组表示范围:-sum-abs(S)到sum+abs(S)
        int B[] = new int[2 * len + 1];
        A[nums[0] + len] += 1;
        A[-nums[0] + len] += 1;
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (flag) {
                for (int j = 0; j < B.length; j++) {
                    B[j] = 0;
                    if (j + nums[i] >= 0 && j + nums[i] < A.length)
                        B[j] += A[j + nums[i]];
                    if (j - nums[i] >= 0 && j - nums[i] < A.length)
                        B[j] += A[j - nums[i]];
                }
                flag = !flag;
            } else  {
                for (int j = 0; j < A.length; j++) {
                    A[j] = 0;
                    if (j + nums[i] >= 0 && j + nums[i] < A.length)
                        A[j] += B[j + nums[i]];
                    if (j - nums[i] >= 0 && j - nums[i] < A.length)
                        A[j] += B[j - nums[i]];
                }
                flag = !flag;
            }
        }
        if (flag)
            return A[S + len];
        return B[S + len];
    }


}
