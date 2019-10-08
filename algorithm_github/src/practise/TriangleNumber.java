package practise;

import java.util.Arrays;

/*
* 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
* */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        if(nums==null||nums.length<3)
            return 0;
        int ans  = 0;
        Arrays.sort(nums);
        int cur = 0;
        //将nums[i] == 0的部分去掉
        while(cur<nums.length&&nums[cur] <1)
            ++cur;
        //从小到大遍历
        for (int small=cur;small<nums.length-2;small++){
            //当mid++时,large并不需要回退
            for (int mid = small+1,large = mid+1;mid<nums.length-1;mid++){
                while (large<nums.length&&nums[large]<nums[small]+nums[mid])
                    ++large;
                ans += large-mid-1;
            }
        }
        return ans;
    }

}
