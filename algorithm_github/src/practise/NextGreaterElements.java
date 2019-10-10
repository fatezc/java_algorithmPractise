package practise;

import java.util.Arrays;
import java.util.Stack;

/*
* 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
* 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-greater-element-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NextGreaterElements {
    //单调栈
    public int[] nextGreaterElements(int[] nums) {
        if (nums==null||nums.length==0)
            return nums;
        int[] ans = new int[nums.length];
        //先全部置为-1，因为下面的循环会把非最大值得部分修改，而且这样可以应对类似于nums={0,0,0,0,0}这种情况
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0,cur; i < nums.length * 2; i++) {
            cur = i%nums.length;
            if (stack.isEmpty()||nums[stack.peek()]>=nums[cur]) stack.push(cur);
           else {
               int temp = stack.pop();
               ans[temp] = nums[cur];
               i--;
            }
        }
        return ans;
    }
}
