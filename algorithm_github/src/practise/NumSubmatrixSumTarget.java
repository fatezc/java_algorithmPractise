package practise;

import java.util.Arrays;
import java.util.HashMap;

/*
* 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。

子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。

如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

/*
    help函数用来求子数组和等于k的情况
    算法思想:比如输入数组是4行，则计算help(第一行)、help(第一行+第二行)、help(第一行+第二行+第三行)、help(第一行+第二行+第三行+第四行)
                                    help(第二行)、help(第二行+第三行)、help(第二行+第三行+第四行)
                                    help(第三行)、help(第三行+第第四行)
                                    help(第四行)

* */
public class NumSubmatrixSumTarget {
    private int ans;
    private HashMap<Integer,Integer> map;
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return 0;
        ans = 0;
        map = new HashMap();
        int[] arr = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(arr,0);
            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    arr[k] += matrix[j][k];
                }
                help(arr,target);
            }
        }
        return ans;
    }
    public void help(int[] help,int target){
        map.clear();
        map.put(0,1);
        int sum = 0;
        for (int i = 0; i < help.length; i++) {
            sum += help[i];
            ans += map.getOrDefault(sum-target,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
    }
}
