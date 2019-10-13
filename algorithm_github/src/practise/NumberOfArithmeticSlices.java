package practise;

import java.util.LinkedList;
import java.util.List;

/*
* 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。

如果满足以下条件，则称子数组(P, Q)为等差数组：

元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。

函数要返回数组 A 中所有为等差数组的子数组个数。
示例:

A = [1, 2, 3, 4]

返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arithmetic-slices
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arithmetic-slices
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A==null||A.length<3)
            return 0;
        //找到每个连续的等差数列的长度存入list，如{1,2,3,4,7,8,9,}则存入4和3
        List<Integer> list = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < A.length-2; ) {
            while (i<A.length-2 && A[i]+A[i+2] != 2*A[i+1]) ++i;
            if (i == A.length-2)
                break;
            int count = 3,gap = A[i+1] - A[i];
            i = i+2;
            while (i<A.length&&A[i+1] - A[i] == gap){
                ++i;
                ++count;
            }
            list.add(count);
        }
        for (Integer integer : list) {
            ans += (integer-1)*(integer-2)/2;
        }
        return ans;
    }

}
