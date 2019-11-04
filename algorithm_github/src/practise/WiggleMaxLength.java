package practise;

import java.util.Stack;

/*
* 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。

例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。

给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
* 进阶:
你能否用 O(n) 时间复杂度完成此题?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/wiggle-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class WiggleMaxLength {
/*
* 数组中的任何元素都对应下面三种可能状态中的一种：

上升的位置，意味着 nums[i] > nums[i - 1]nums[i]>nums[i−1]
下降的位置，意味着 nums[i] < nums[i - 1]nums[i]<nums[i−1]
相同的位置，意味着 nums[i] == nums[i - 1]nums[i]==nums[i−1]
更新的过程如下：

如果 nums[i] > nums[i-1]nums[i]>nums[i−1] ，意味着这里在摆动上升，前一个数字肯定处于下降的位置。所以 up[i] = down[i-1] + 1up[i]=down[i−1]+1 ， down[i]down[i] 与 down[i-1]down[i−1] 保持相同。

如果 nums[i] < nums[i-1]nums[i]<nums[i−1] ，意味着这里在摆动下降，前一个数字肯定处于下降的位置。所以 down[i] = up[i-1] + 1down[i]=up[i−1]+1 ， up[i]up[i] 与 up[i-1]up[i−1] 保持不变。

如果 nums[i] == nums[i-1]nums[i]==nums[i−1] ，意味着这个元素不会改变任何东西因为它没有摆动。所以 down[i]down[i] 与 up[i]up[i] 与 down[i-1]down[i−1] 和 up[i-1]up[i−1] 都分别保持不变。

最后，我们可以将 up[length-1]up[length−1] 和 down[length-1]down[length−1] 中的较大值作为问题的答案，其中 lengthlength 是给定数组中的元素数目。

下面的例子可以说明这一过程：

作者：LeetCode
链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
    public int wiggleMaxLength(int[] nums) {
       if (nums.length<2)
           return nums.length;
       int up = 1,down = 1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]-nums[i-1]>0)
                up = down+1;
            if (nums[i]-nums[i-1]<0)
                down = up+1;
        }
        return Math.max(up,down);
    }

}
