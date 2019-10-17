package practise;

import java.util.LinkedList;
import java.util.List;
/*
* 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
* 输入: [0,2,3,4,6,8,9]
输出: ["0","2->4","6","8->9"]
解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/summary-ranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        if (nums==null||nums.length==0)
            return ans;
        int left=0,right=0;
        while (right<nums.length){
            while (right+1<nums.length&&nums[right+1]-nums[right] == 1) ++right;
            if (left<right)
            ans.add(nums[left]+"->"+nums[right]);
            else ans.add(""+nums[left]);
            left = ++right;
        }
        return ans;
    }
}
