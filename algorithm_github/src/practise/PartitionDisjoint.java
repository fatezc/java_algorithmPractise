package practise;
/*
* 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：

left 中的每个元素都小于或等于 right 中的每个元素。
left 和 right 都是非空的。
left 要尽可能小。
在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
* 提示：

2 <= A.length <= 30000
0 <= A[i] <= 10^6
可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class PartitionDisjoint {
    public int partitionDisjoint(int[] A) {
        int[] help = new int[A.length];
        help[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            help[i] = A[i]>help[i-1]?A[i]:help[i-1];
        }
        int ans = A.length;
        int right_min = Integer.MAX_VALUE;
        for (int i = A.length-1; i >0 ; i--) {
            right_min = Math.min(right_min,A[i]);
            if (help[i-1]<=right_min)
                ans = i;
        }
        return ans;
    }
}
