package practise;
/*
* 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。

移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

返回尽可能高的分数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class InvertSquare {

    public int matrixScore(int[][] A) {
        if (A == null||A.length==0)
            return 0;
        int ans = 0;
        //先按行翻转,确保第一位为1
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0){
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] = A[i][j]==0?1:0;
                }
            }
        }
        //再按列来翻转,使同一列上1更多
        for (int i = A[0].length-1,count = 1,help; i >=0 ; i--) {
            help = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1)
                    help++;
            }
            ans += count*(Math.max(help,A.length-help));
            count *= 2;
        }
        return ans;
    }
}
