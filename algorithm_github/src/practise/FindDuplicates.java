package practise;

import java.util.LinkedList;
import java.util.List;
/*
* 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        /*
        针对每个数组中的数num，将下标为num的值加上n,然后再遍历nums，找出nums[i]>2*n的下标值
         */
        for (int i = 0; i < nums.length; i++) {
            nums[nums[i]%nums.length] += nums.length;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>2*nums.length)
                ans.add(i>0?i:nums.length);
        }
        return ans;
    }
}
