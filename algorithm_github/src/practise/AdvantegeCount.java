package practise;

import java.util.Arrays;
import java.util.Comparator;

/*
* 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。

返回 A 的任意排列，使其相对于 B 的优势最大化。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/advantage-shuffle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class AdvantegeCount {
    /*
    算法思想:先将A排序，然后从小到大对A[i]进行如下操作：
                    找B中还未被操作的集合中最小的值，如果该值小于A[i]，则将A[i]于其比较，否则将A[i]于B中最大值比较
     */
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        //BAndIndex用于保证B排序仍然可以得到原始B的索引
        int[][] BAndIndex = new int[B.length][2];
        for (int i = 0; i < B.length; i++) {
            BAndIndex[i][0] = B[i];
            BAndIndex[i][1] = i;
        }
        Arrays.sort(BAndIndex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] ans = new int[A.length];
        for (int i = 0,j = 0,k =A.length-1; i < A.length; i++) {
            if (A[i]>BAndIndex[j][0]){
                ans[BAndIndex[j++][1]] = A[i];
            }else {
                ans[BAndIndex[k--][1]] = A[i];
            }
        }
        return ans;
    }
}
