package practise;
/*
* 给定一个长度为 n 的整数数组 A 。

假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。

计算F(0), F(1), ..., F(n-1)中的最大值。

注意:
可以认为 n 的值小于 105。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-function
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxRotateFunction {
    /*
    经推导可得F(i+1) - F(i) = sumA - nA[n-i-1]
     */
    public int maxRotateFunction(int[] A) {
        int F = 0,sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+= A[i];
            F += i*A[i];
        }
        int ans = F;
        for (int i = 1; i < A.length; i++) {
            F += (sum - A.length*A[A.length-i]);
            ans = Math.max(ans,F);
        }
        return ans;
    }

}
