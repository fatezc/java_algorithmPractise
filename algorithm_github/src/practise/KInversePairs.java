package practise;
/*
* 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。

逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。

由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-inverse-pairs-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class KInversePairs {
    /*
    动态规划，dp[i,j]表示kInversePairs(i,j),则dp[i,j] = dp[i-1,j]+dp[i-1,j-1]+...+dp[i-1,j-(i-1)]
    该等式来自于:因为i必然大于1~i-1，且对于1~i-1的任何排列，i有i个位置可以放入，放在最前面则增加了i-1个逆序对，放在最后面则增加了0个逆序对
                所以可得上述等式，当然，要考虑j-(i-1)<0的情况
     */
    public int kInversePairs(int n, int k) {
        int mod = 1_000_000_007;
        if (n==1)
            return k==0?1:0;
        if (k==0)
            return 1;
        int[] dp = new int[k+1];
        dp[0] = 1;
        int i = 2;
        //由于dp[i,j]每次更新只需要上一行的值，故可以直接压缩成一行来迭代dp
        while (i<=n){
            for (int j = k; j >0 ; j--) {
                for (int l =j-(i-1) ; l <= j-1; l++) {
                    if (l>=0){
                        dp[j] += dp[l]%mod;
                        dp[j] %= mod;
                    }
                }
            }
            ++i;
        }
        return dp[k];
    }

}
