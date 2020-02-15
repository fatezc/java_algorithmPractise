package practise;
/*
* 有两种形状的瓷砖：一种是 2x1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。

XX  <- 多米诺

XX  <- "L" 托米诺
X
给定 N 的值，有多少种方法可以平铺 2 x N 的面板？返回值 mod 10^9 + 7。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/domino-and-tromino-tiling
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumTilings {
    /*
    * dp[n]=dp[n-1]+dp[n-2]+(dp[0]+dp[1]+...+dp[n-3])*2
再结合dp[n-1]=dp[n-2]+dp[n-3]+(dp[0]+dp[1]+...+dp[n-4])*2
可得dp[n]=dp[n-1]*2+dp[n-3]

    * */
    public int numTilings(int N) {
        if (N == 1)
            return 1;
        if (N == 2)
            return 2;
        if (N == 3)
            return 5;
        long a1 = 1,a2 = 2,a3 = 5,temp = a3,mod = 1_000_000_007L;
        while (N - 3>0){
            temp = 2*a3 + a1;
            temp %= mod;
            a1 = a2;
            a2 = a3;
            a3 = temp;
            --N;
        }
        return (int)temp;
    }
}
