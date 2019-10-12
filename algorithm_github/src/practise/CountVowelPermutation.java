package practise;

import java.util.Arrays;
/*
*
* 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：

字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
每个元音 'a' 后面都只能跟着 'e'
每个元音 'e' 后面只能跟着 'a' 或者是 'i'
每个元音 'i' 后面 不能 再跟着另一个 'i'
每个元音 'o' 后面只能跟着 'i' 或者是 'u'
每个元音 'u' 后面只能跟着 'a'
由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-vowels-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CountVowelPermutation {
    /*
    dp_help记录到i-1位置分别是各个字母的情况数，0~4分别对应（'a', 'e', 'i', 'o', 'u'）
    然后根据dp_help来就算i位置分别是各字母的情况数存入dp_1,
     */
    public int countVowelPermutation(int n) {
        if (n<=0)
            return 0;
        if (n==1)
            return 5;
        int[] dp_1 = new int[5];
        int[] dp_help = new int[5];
        int mod = 1000_000_007;
        int[] temp;
        Arrays.fill(dp_1,1);
        for (int i = 1; i < n ; i++) {
            temp = dp_1;
            dp_1 = dp_help;
            dp_help = temp;
            dp_1[0] = ((dp_help[1]+dp_help[2])%mod+dp_help[4])%mod;
            dp_1[1] = (dp_help[0]+dp_help[2])%mod;
            dp_1[2] = (dp_help[1]+dp_help[3])%mod;
            dp_1[3] = dp_help[2]%mod;
            dp_1[4] = (dp_help[2]+dp_help[3])%mod;
        }
        int ans = 0;
        for (int i = 0; i < dp_1.length; i++) {
            ans += dp_1[i];
            ans %= mod;
        }
        return ans;
    }
}
