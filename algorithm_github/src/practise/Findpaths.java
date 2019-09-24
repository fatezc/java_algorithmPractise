package practise;
/*
* 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。
* 但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/out-of-boundary-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Findpaths {
    /*
    运用dp的思想，每次记录超界限的值
     */
    public int findPaths(int m, int n, int N, int i, int j) {
        //先将原数组加一圈，以便每次统计超出界限的值
        int[][] dp = new int[m+2][n+2];
        int[][] temp = new int[m+2][n+2];
        int mod = 1000000007;
        int ans = 0;
        dp[i+1][j+1] = 1;
        for (int k = 0; k < N ; k++) {
            for (int l = 1; l < m+1; l++) {
                for (int o = 1; o < n+1; o++) {
                    if (dp[l][o] >0 ){
                        if (l+1<m+2){
                            temp[l+1][o] += dp[l][o];
                            temp[l+1][o] %= mod;
                        }
                        if (o+1<n+2){
                            temp[l][o+1] += dp[l][o];
                            temp[l][o+1] %= mod;
                        }
                        if (l-1>=0){
                            temp[l-1][o] += dp[l][o];
                            temp[l-1][o] %= mod;
                        }
                        if (o-1>=0){
                            temp[l][o-1] += dp[l][o];
                            temp[l][o-1] %= mod;
                        }
                    }
                }
            }
            for (int l = 0; l < m+2; l++) {
                for (int o = 0; o < n+2; o++) {
                    dp[l][o] = temp[l][o];
                    temp[l][o] = 0;
                }
            }
            //以下为每次统计dp数组最外层的值，即超出界限的值
            for (int l = 0; l < m+2; l++) {
                ans += (dp[l][0]+dp[l][n+1]);
                ans %= mod;
                dp[l][0] = 0;
                dp[l][n+1] = 0;
            }
            for (int l = 1; l < n+1; l++) {
                ans +=( dp[0][l]+dp[m+1][l]);
                ans %= mod;
                dp[0][l]=0;
                dp[m+1][l]=0;
            }

        }



        return ans %mod;
    }
}
