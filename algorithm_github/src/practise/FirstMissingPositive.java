package practise;
/*
* 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
* */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums == null||nums.length == 0)
            return 1;
        int temp;
        /*
        尽量使nums[i]存储i+1
         */
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i+1 //当nums[i]不存储i+1时
                    && nums[i]-1>=0 &&nums[i]-1<nums.length//保证不越界
                    &&nums[nums[i]-1]!=nums[i]//当nums[nums[i]-1]不存储nums[i]时
                    )
            {   //交换nums[i]和nums[nums[i]-1]的值，使得nums[nums[i]-1]存储nums[i]
                temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }
}
