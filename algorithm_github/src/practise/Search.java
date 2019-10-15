package practise;
/*
* 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Search {
    /*
    先通过二分查找找出旋转的点,如上例中的7,然后在7的左段或者右段进行二分查找
     */
    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0)
            return -1;
        int left = 0,right = nums.length-1,split=0;
        //找旋转点
        while (left<=right){
            int mid = left+(right-left)/2;
            if (mid+1<nums.length&&nums[mid]>nums[mid+1]){
                split = mid;
                break;
            }
            if (nums[mid]<nums[left])
                right = mid-1;
            else
                left = mid+1;
        }
        /*
        先给left和right复制0和length-1是为了以防数组为[1]或者[1,3]这些不存在转折点的情况情况
         */
        left = 0;
        right = nums.length;
        //如果存在转折点,则更新left和right
        if (target>nums[nums.length-1]){
            left = 0;
            right = split;
        }else if(target<nums[0]){
            left = split+1;
            right = nums.length-1;
        }

        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid]>target)
                right = mid-1;
            if (nums[mid]<target)
                left = mid+1;
        }
        return -1;
    }

}
