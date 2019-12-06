package practise;
/*
* 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。

每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。

给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。

由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。

* 1 <= steps <= 500
1 <= arrLen <= 10^6
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumWays {
    public int numWays(int steps, int arrLen) {
        if (arrLen == 1)
            return 1;
        int mod = (int)Math.pow(10,9)+7;
        long[] dp_pre = new long[arrLen];
        long[] dp_new = new long[arrLen];
        long[] dp_temp;
        dp_pre[0] = 1;
        dp_pre[1] = 1;
        for (int i = 1; i < steps; i++) {
            dp_new[0] = (dp_pre[0]+dp_pre[1])%mod;
            dp_new[arrLen-1] = (dp_pre[arrLen-1] + dp_pre[arrLen-2])%mod;
            for (int j = 1; j <Math.min(arrLen-1,i+2) ; j++) {//如果arrlen>steps，那么每次更新数组最多更新到i+1的位置，后面全是0
                dp_new[j] = (dp_pre[j-1]%mod + dp_pre[j]%mod + dp_pre[j+1]%mod)%mod;
            }
            dp_temp = dp_new;
            dp_new = dp_pre;
            dp_pre = dp_temp;
        }
        return (int)dp_pre[0];
    }
}
