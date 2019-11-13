package practise;
/*
* 一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumDecodings {
    /*
    算法思想：如果i和i-1可以合成“10”~“26”则dp[i] = dp[i-1]+dp[i-2]，否则dp[i] = dp[i-1]
    主要要考虑某个位置是‘0’的情况
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        if (s.length()==1)
            return 1;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            if (s.charAt(i-1)=='0'&&(s.charAt(i-2)!='1'&&s.charAt(i-2)!='2'))
                return 0;
            if (s.charAt(i-1) == '0')
                dp[i] = dp[i-2];
            else if (s.charAt(i-2)=='1'||(s.charAt(i-2)=='2'&&s.charAt(i-1)<='6'))
                dp[i] = dp[i-1]+dp[i-2];
            else dp[i] = dp[i-1];
        }
        return dp[s.length()];
    }
}
