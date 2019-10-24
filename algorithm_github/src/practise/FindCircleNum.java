package practise;
/*
* 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

* 注意：

N 在[1,200]的范围内。
对于所有学生，有M[i][i] = 1。
如果有M[i][j] = 1，则有M[j][i] = 1。
*
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/friend-circles
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class FindCircleNum {
    /*
    运用并查集的思想，其中help[i]表示与i是朋友的最小编号学生，这样最后help[i] == i的学生就是朋友圈数
     */
    public int findCircleNum(int[][] M) {
        int[] help = new int[M.length];
        for (int i = 0; i < help.length; i++) {
            help[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = i+1; j <M.length ; j++) {
                if (M[i][j] == 1){
                    int bigger = Math.max(help[i],help[j]);
                    int smaller = help[i]+help[j]-bigger;
                    for (int k = 0; k < help.length; k++) {
                        if (help[k] == bigger)
                            help[k] = smaller;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < help.length; i++) {
            if (help[i] == i)
                ans++;
        }
        return ans;
    }
}
