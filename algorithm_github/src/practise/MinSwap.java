package practise;
/*我们有两个长度相等且不为空的整型数组 A 和 B 。

我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。

在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。

给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinSwap {
    //dp
    public int minSwap(int[] A, int[] B) {
        if (A.length<2)
            return 0;
        //每次用noSwap记录将当前位置不交换保持递增所需的最少交换次数，isSwap记录将当前位置交换之后保持递增所需的最少交换次数
        int noSwap = 0,isSwap = 1;
        boolean f1,f2;
        for (int i = 1; i <A.length ; i++) {
            f1 = A[i]>A[i-1] && B[i]>B[i-1];//f1为真表示A[i]可以在A[i-1]后面，A[i]可以在B[i-1]后面
            f2 = A[i]>B[i-1] && B[i]>A[i-1];//f2为真表示A[i]可以在B[i-1]后面，B[i]可以在A[i-1]后面
            //f1&&f2表示交换不交换都可以
            if (f1&&f2){
                noSwap = Math.min(noSwap,isSwap);
                isSwap = 1 + noSwap;
            }
            //当原A[i]只能在原A[i-1]后面时
            else if (f1){
                isSwap = isSwap+1;
            }
            //当原A[i]只能在原B[i-1]后面时
            else if(f2){
                int k =isSwap;
                isSwap = 1+noSwap;
                noSwap = k;
            }
        }
        return Math.min(isSwap,noSwap);
    }
}
