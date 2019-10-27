package practise;
/*
* 给你一个整数数组 arr 和一个整数 k。

首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。

举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。

然后，请你返回修改后的数组中的最大的子数组之和。

注意，子数组长度可以是 0，在这种情况下它的总和也是 0。

由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-concatenation-maximum-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class KConcatenationMaxSum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1_000_000_007;
        long ans = 0,minsum = 0;
        long[] sum = new long[arr.length*2+1];
        for (int i = 0; i < arr.length; i++) {
            sum[i+1] = sum[i]+arr[i];
        }
        for (int i = arr.length; i <2*arr.length ; i++) {
            sum[i+1] = sum[i]+arr[i-arr.length];
        }
        for (int i = 1; i < arr.length+1; i++) {
            ans = Math.max(ans,sum[i] - minsum);
            minsum = Math.min(minsum,sum[i]);
        }
        //到此ans为一个arr数组中的最大子数组之和
        if (ans == 0||k == 1)
            return (int)ans;
        long help = -1;
        for (int i = arr.length+1; i <sum.length ; i++) {
            help = Math.max(help,sum[i]-minsum);
        }
        //到此help表示左端在第一个arr数组，右端在第二个arr数组的最大子数组之和
        ans = Math.max(ans,help);

        //如果arr数组的和大于0，则可以在两个数组之间插入k-2个数组
        if (sum[arr.length+1]>0){
            ans = Math.max(ans,help+(k-2)*sum[arr.length+1]);
        }
        ans = ans %mod;
        return (int)ans;
    }
}
