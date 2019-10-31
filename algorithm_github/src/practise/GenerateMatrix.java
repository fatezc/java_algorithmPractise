package practise;
/*
* 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
* 输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
* */
public class GenerateMatrix {
    private int cur;
    private int N;
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        cur = 1;
        N = n;
        int count =0;
        while (cur<=N*N){
            help(ans,count++);
        }
        return ans;
    }
    //打印一圈
    public void help(int[][] ans,int count){
        for (int i = count; i < N-count&&cur<=N*N; i++) {
            ans[count][i] = cur++;
        }
        for (int i = count+1; i <N-count && cur<=N*N; i++) {
            ans[i][N-1-count] = cur++;
        }
        for (int i = N-count-2; i >=count&&cur<=N*N ; i--) {
            ans[N-1-count][i] = cur++;
        }
        for (int i = N-count-2; i >count&&cur<=N*N ; i--) {
            ans[i][count] = cur++;
        }
    }
}
