package practise;
/*
* 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。
* */
public class FindK {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0],right = matrix[matrix.length-1][matrix[0].length-1];
        int mid,num;
        while (left<right){
            mid = left+(right-left)/2;
            num = count(matrix,mid);
            if (num>=k)
                right = mid;
            if (num<k)
                left = mid+1;
        }
        return right;
    }
    //统计matrix中<=mid的个数
    public int count(int[][] matrix,int mid){
        int i = matrix.length-1;
        int j =0;
        int ans = 0;
        while (i>=0&&j<matrix[0].length){
            if (matrix[i][j]<=mid){
                ans+=i+1;
                ++j;
            }
            else {
                --i;
            }
        }
        return ans;
    }
}
