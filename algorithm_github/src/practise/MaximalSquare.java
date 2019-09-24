package practise;
/*在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
* */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null ||matrix.length==0)
            return 0;
        int ans = 0;
        //以防该矩阵只有一行或者一列
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]-'0' == 1)
                ans = 1;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i]-'0' == 1)
                ans = 1;
        }

        /*计算以[i][j]为右下角的最大正方形面积:
                        1.matrix[i][j] == 0,则为0
                        2.matrix[i][j] == 1,则该正方形的边长由[i-1][j],[i-1][j-1],[i][j-1]三个点为右下角的三个最大正方形边长决定
        * */
        for (int i = 1; i <matrix.length ; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]-'0' == 1)
                    matrix[i][j] += Math.min(matrix[i-1][j]-'0',Math.min(matrix[i-1][j-1]-'0',matrix[i][j-1]-'0'));
                ans = Math.max(ans,(matrix[i][j]-'0')*(matrix[i][j]-'0'));
            }
        }
        return ans;
    }

}