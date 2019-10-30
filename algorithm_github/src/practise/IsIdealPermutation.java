package practise;
/*
* 数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。

当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/global-and-local-inversions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IsIdealPermutation {
    //由题意知局部倒置是全局倒置的一种特殊情况,故只要检查有没有不是局部倒置的全局倒置即可
    public boolean isIdealPermutation(int[] A) {
        if (A.length<=2)
            return true;
        int min_cur = A.length-1;
        for (int i = A.length-3; i >=0 ; i--) {
            if (A[min_cur]<A[i])
                return false;
            if (A[min_cur]>A[i+1])
                min_cur=i+1;
        }
        return true;
    }
}
