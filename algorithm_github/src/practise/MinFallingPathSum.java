package practise;
/*
* 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。

下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinFallingPathSum {
    //对于[i,j]，只有可能从[i-1][j-1]，[i-1][j],[i-1][j+1]走过来
    public int minFallingPathSum(int[][] A) {
        for (int i = 1; i <A.length ; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == 0)
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                else if (j==A[0].length-1)
                    A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
                else A[i][j] += Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            ans = Math.min(ans,A[A.length-1][i]);
        }
        return ans;
    }
}
