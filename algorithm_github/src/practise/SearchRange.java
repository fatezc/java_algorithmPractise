package practise;
/*
* 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0]>target || nums[nums.length-1]<target)
            return new int[]{-1,-1};
        int[] ans = new int[]{-1,-1};
        int left = 0, right = nums.length-1,mid;
        if (nums[0] == target)
            ans[0] = 0;
        else {
            while (left<right){
                mid = (left+right)/2;
                if (nums[mid] > target)
                    right = mid-1;
                else if (nums[mid] < target)
                    left = mid+1;
                else if ( nums[mid - 1]<target){
                    ans[0] = mid;
                    break;
                }
                else right = mid -1;
            }
            /*
            * 如: nums = [5,7,7,8,8,10], target = 8时
            * 如果没有这一行,就会以left == right为while的循环结束的条件
            * 此时ans[0]并未被改变
            * */
            if (left == right && nums[left] == target && nums[left -1] <target)
                ans[0] = left;
        }
        left = 0;
        right = nums.length-1;
        if (nums[nums.length-1] == target)
            ans[1] = nums.length-1;
        else {
            while (left<right){
                mid = (left+right)/2;
                if (nums[mid] > target)
                    right = mid-1;
                else if (nums[mid] < target)
                    left = mid+1;
                else if ( nums[mid + 1]>target){
                    ans[1] = mid;
                    break;
                }
                else left = mid +1;
            }
            if (left == right && nums[left] == target && nums[left +1] >target)
                ans[1] = left;
        }
        return ans;
    }
}
