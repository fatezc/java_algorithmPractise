package practise;

/*
* 给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。

返回经过一些翻转后，行上所有值都相等的最大行数

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class MaxEqualRowsAfterFlips {
    /*
    尝试将第i行翻转为全1或者全0,然后计算整个矩阵满足条件的行数,总共有2*matrix.length种可能
    时间复杂度为o(m*m*n),其中m = matrix.length,n = matrix[0].length
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
       int ans = 0;
       int[] help = new int[matrix.length];
       int[] temp = new int[matrix.length];
       //先将每一行的和统计为help
        for (int i = 0; i <matrix[0].length ; i++) {
            for (int j = 0; j < help.length; j++) {
                help[j] += matrix[j][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            //将help复制给temp
            for (int j = 0; j < help.length; j++) {
                temp[j] = help[j];
            }
            for (int j = 0; j < matrix[0].length; j++) {
                //将该行的1翻转为0的情况,并不是在原数组中翻转,而是计算翻转后每行的和的值计入temp
                if (matrix[i][j] == 1){
                    for (int k = 0; k < temp.length; k++) {
                        temp[k] += (1 - 2*matrix[k][j]);
                    }
                }
            }
            int h1 = 0;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 0 ||temp[j] == matrix[0].length)//该行全为0或者全为1
                    ++h1;
            }
            ans = Math.max(ans,h1);
            //以下为将该行翻转为全1的情况
            for (int j = 0; j < help.length; j++) {
                temp[j] = help[j];
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    for (int k = 0; k < temp.length; k++) {
                        temp[k] += (1 - 2*matrix[k][j]);
                    }
                }
            }
            h1 = 0;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 0 ||temp[j] == matrix[0].length)
                    ++h1;
            }
            ans = Math.max(ans,h1);
        }
        return ans;
    }
}
