package practise;

import java.util.Arrays;
import java.util.TreeSet;

/*
* 给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
* 说明：

矩阵内的矩形区域面积必须大于 0。
如果行数远大于列数，你将如何解答呢？
* */
public class MaxSumSubmatrix {
    /*
    help函数用来求子数组和小于等于k的情况下的最大和，该函数时间复杂度NlogN
    算法思想:比如输入数组是4行，则计算help(第一行)、help(第一行+第二行)、help(第一行+第二行+第三行)、help(第一行+第二行+第三行+第四行)
                                    help(第二行)、help(第二行+第三行)、help(第二行+第三行+第四行)
                                    help(第三行)、help(第三行+第第四行)
                                    help(第四行)
                                    得到所有返回值中最大的k
                                    这个过程的复杂度为N*N
     当行数M远大于大于N的时候，原则将每列作为help的输入数组，这样时间复杂度为N*N*MlogM
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null||matrix.length ==0)
            return 0;
        int ans = Integer.MIN_VALUE,m = matrix.length,n = matrix[0].length;
        int[] arr = new int[m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr,0);
            for (int j = i; j < n ; j++) {
                for (int p = 0; p < m; p++) {
                    arr[p] += matrix[p][j];
                }
                ans = Math.max(ans,help(arr,k));
            }
        }
        return ans;
    }
    public int help(int[] help,int k){
        int ans = Integer.MIN_VALUE,sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < help.length; i++) {
            sum += help[i];
            if (set.ceiling(sum-k)!=null)
                ans = Math.max(ans,sum-set.ceiling(sum-k));
            set.add(sum);
        }
        return ans;
    }
}
