package practise;

import java.util.Arrays;

/*
* 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。 

现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。 

如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。

求移动结束后，“马” 仍留在棋盘上的概率。
注意：

N 的取值范围为 [1, 25]
K 的取值范围为 [0, 100]
开始时，“马” 总是位于棋盘上
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class KnightProbability {
    /*
    用两个N*N的数组,每次都用旧的数组的数据来更新新的数组,全部初始化为1,更新K次即可
     */
    public double knightProbability(int N, int K, int r, int c) {
        int[][] direction = {
                {-2,1},
                {-1,2},
                {1,2},
                {2,1},
                {1,-2},
                {-1,-2},
                {-2,-1},
                {2,-1},
        };
        double[][] dp_new = new double[N][N];
        double[][] dp_old = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp_new[i][j] = 1;
            }
        }
        double[][] temp;
        for (int i = 0; i < K; i++) {
            //交换新旧数组
            temp = dp_new;
            dp_new = dp_old;
            dp_old = temp;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    dp_new[j][k] = 0;
                    for (int l = 0; l < direction.length; l++) {
                        //8个方向依次判断
                        if (k+direction[l][1]>=0 && k+direction[l][1]<N && j+direction[l][0]>=0 && j+direction[l][0]<N)
                            dp_new[j][k] += dp_old[j + direction[l][0]][k + direction[l][1]];
                    }
                    dp_new[j][k] /= 8;
                }
            }
        }
        return dp_new[r][c];
    }
}
