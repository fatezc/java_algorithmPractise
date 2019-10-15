package practise;

import java.util.LinkedList;
import java.util.List;
/*
* 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class FindDisappearedNumbers {
    /*
    既然不能用额外空间，则在原数组上标识包含1~n的哪些
    将数组元素对应为索引的位置加n
    遍历加n后的数组，若数组元素值小于等于n，则说明数组下标值不存在，即消失的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans =  new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i]-1)%nums.length;//后续操作会改变nums数组的值，对n取余能提取出nums[i]原本的值
            nums[index] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=nums.length)
                ans.add(i+1);
        }
        return ans;
    }
}
