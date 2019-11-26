package practise;
/*
* 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
* 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
* */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int left = 0,right = nums.length-1,mid;
        while (left<right){
            mid = (left+right)/2;
            //找到该元素
            if ((mid-1<0 || nums[mid-1]!=nums[mid]) && (mid+1>=nums.length || nums[mid+1]!=nums[mid]))
                return nums[mid];
            /*
            下面四种情况分别为nums[mid] == nums[mid-1],nums[mid] == nums[mid+1];[left,mid]包含奇数个元素还是偶数个元素的四种组合
            left,mid,right将查找区域分为两个部分，由于其他都成对，所以该唯一数必然在总数为奇数的半边
             */
            if (nums[mid-1] == nums[mid] && (mid-left)%2 == 0)
                right = mid-2;
            else if(nums[mid+1] == nums[mid] && (mid-left)%2 == 1)
                right = mid-1;
            else if (nums[mid-1] == nums[mid] && (mid - left) %2 ==1)
                left = mid+1;
            else if (nums[mid+1] == nums[mid] && (mid - left) %2 ==0)
                left = mid+2;
        }
        return nums[left];
    }
}
