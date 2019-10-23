package practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/*
* 给定一个整数数组 A ，考虑 A 的所有非空子序列。

对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。

返回 A 的所有子序列的宽度之和。

由于答案可能非常大，请返回答案模 10^9+7。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-subsequence-widths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SumSubseqWidths {
    /*
    得到每个数字出现的次数存入map
    然后对map对应的keyset排序，这不影响结果
    然后对set中的每个0<i<j<length,计算可能的排列种数，其中要考虑i个个数，j的个数，大于i小于j的数字个数
    然后得到一对(i,j)产生的宽度，累加
    该方法正确，但超时
     */
    public int sumSubseqWidths(int[] A) {
        if (A.length == 1)
            return 0;
        int mod = (int)Math.pow(10,9)+7;
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Object[] objects = map.keySet().toArray();
        int[][] help = new int[objects.length][2];
        Arrays.sort(objects);
        help[0][0] = (int)objects[0];
        help[0][1] = map.get(objects[0]);
        for (int i = 1; i < help.length; i++) {
            help[i][0] = (int)objects[i];
            help[i][1] = help[i-1][1]+map.get(objects[i]);
        }
        long temp = (long)Math.pow(2,30);//用来加速
        for (int i = 0; i < help.length- 1; i++) {
            for (int j = i+1; j <help.length ; j++) {
                int midNum = help[j-1][1] - help[i][1];
                long midKinds = 1;
                while (midNum>30){
                    midKinds = midKinds*temp%mod;
                    midNum -= 30;
                }
                while (midNum>0){
                    midKinds = midKinds*2%mod;
                    midNum--;
                }
                int iNum = map.get(help[i][0]);
                int jNum = map.get(help[j][0]);
                long i_kinds = ((long)Math.pow(2,iNum) - 1)%mod;
                long j_kinds = ((long)Math.pow(2,jNum) - 1)%mod;
                ans = ans + (long)(help[j][0] - help[i][0])*i_kinds*j_kinds*midKinds;
                ans %= mod;
            }
        }
        return (int)ans;
    }
    /*
    官方题解：思路

让我们试着统计具有最小值 A[i] 和最大值 A[j] 的子序列的数量。

算法

我们可以对数组进行排序，因为这并不会改变答案。对数组进行排序后，我们可以得知有最小值 A[i] 和最大值 A[j] 的子序列的数目是 2^{j-i-1}。
因此，期望的答案为：公式推导为图片，详见下面的网址

作者：LeetCode
链接：https://leetcode-cn.com/problems/sum-of-subsequence-widths/solution/zi-xu-lie-kuan-du-zhi-he-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int sumSubseqWidths2(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i)
            pow2[i] = pow2[i-1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < N; ++i)
            ans = (ans + (pow2[i] - pow2[N-1-i]) * A[i]) % MOD;

        return (int) ans;
    }
}
