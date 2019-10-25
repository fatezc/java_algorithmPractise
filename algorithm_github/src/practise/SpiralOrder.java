package practise;

import java.util.LinkedList;
import java.util.List;
/*
* 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
* */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix.length==0)
            return ans;
        int m = matrix.length-1,n = matrix[0].length-1;
        int upRow = 0,upCol = 0;
        while (upRow<=m && upCol<=n){
            circle(matrix,upRow,upCol,m,n,ans);
            upCol++;
            upRow++;
            m--;
            n--;
        }
        return ans;
    }
    //对每一圈进行操作
    public void circle(int[][] matrix,int upRow,int upCol,int downRow,int downCol,List<Integer> list){
        if (upRow == downRow && upCol == downCol){
            list.add(matrix[upRow][upCol]);
            return;
        }
        if (upRow == downRow){
            for (int i = upCol; i <= downCol; i++) {
                list.add(matrix[upRow][i]);
            }
            return;
        }
        if (upCol == downCol){
            for (int i = upRow; i <=downRow ; i++) {
                list.add(matrix[i][upCol]);
            }
            return;
        }
        for (int i = upCol; i <downCol ; i++) {
            list.add(matrix[upRow][i]);
        }
        for (int i = upRow; i < downRow; i++) {
            list.add(matrix[i][downCol]);
        }
        for (int i = downCol; i > upCol; i--) {
            list.add(matrix[downRow][i]);
        }
        for (int i = downRow; i >upRow ; i--) {
            list.add(matrix[i][upCol]);
        }
    }
}
