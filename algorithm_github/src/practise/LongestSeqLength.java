package practise;
/*给定一个整数数组 A，返回 A 中最长等差子序列的长度。

回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-arithmetic-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
2 <= A.length <= 2000
0 <= A[i] <= 10000
* */
public class LongestSeqLength {
    public int longestArithSeqLength(int[] A) {
        //先计算出最大差值,以节省dp数组的空间
        int max = 0,min = 10000;
        for (int i : A) {
            max = max<i?i:max;
            min = min>i?i:min;
        }
        int maxdiff = max - min;

        int diff,ans = 0;
        //dp[a][b]表示以A[a]为结尾的差值为b的最长子序列个数.长度为maxdiff*2+1是将差值为-maxdiff到maxdiff右移到0到maxdiff*2
        int[][] dp =new  int[A.length][maxdiff*2+1];
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                diff = A[i] - A[j]+maxdiff;//加maxdiff来完成下标右移
                dp[i][diff] = Math.max(2,dp[j][diff]+1);//最小等差序列为2
                ans = Math.max(ans,dp[i][diff]);//记录最大序列
            }
        }
        return ans;
    }
}
