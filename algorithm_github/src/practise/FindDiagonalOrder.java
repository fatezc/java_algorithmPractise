package practise;
/*
* 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
* 输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]
* */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int[] ans = new int[matrix.length*matrix[0].length];
        //left和right分别存储每一次遍历的对角线的两个端点，flag表示遍历方向
        int[] left = new int[2];
        int[] right = new int[2];
        int flag = 1,i = 0;
        while (i<ans.length){
            if (flag == 1){
                for (int row = left[0],col = left[1];row>=right[0];row--,col++)
                    ans[i++] = matrix[row][col];
            }else {
                for (int row = right[0],col = right[1];row<=left[0];row++,col--)
                    ans[i++] = matrix[row][col];
            }
            if (left[0] == matrix.length-1)
                left[1]++;
            else left[0]++;
            if (right[1] == matrix[0].length-1)
                right[0]++;
            else right[1]++;
            flag = -flag;
        }
        return ans;
    }
}
