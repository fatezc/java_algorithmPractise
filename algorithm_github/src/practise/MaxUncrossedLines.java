package practise;

import java.util.HashMap;
import java.util.HashSet;

/*
* 我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。

现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。

以这种方法绘制线条，并返回我们可以绘制的最大连线数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/uncrossed-lines
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxUncrossedLines {
    /*
    我们设函数f(x,y)标识A的前x个数字和B的前y个数字，能绘制出的最大连接数。假设A、B都是从下标1开始。

则f(0,y)=0,f(x,0)=0;

情况1：
如果A[x]!=B[y]，那么f(x,y)=max(f(x-1,y),f(x,y-1));
情况2：
如果A[x]==B[y]，那么f(x,y)=f(x-1,y-1)+1;

可以看出这个递推式与求最长公共自序列一样，因为最长公共自序列即满足A[i]==B[j]，又因为每一对都是前后有序，所以保证不想交，最长又保证了最大连线数
     */
    public int maxUncrossedLines(int[] A, int[] B) {
       int[][] dp = new int[A.length+1][B.length+1];
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                if (A[i-1] == B[j-1])
                    dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
