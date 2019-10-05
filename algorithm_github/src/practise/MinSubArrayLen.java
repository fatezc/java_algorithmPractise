package practise;
/*
* 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
* */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0,right = 0,sum = 0,ans = Integer.MAX_VALUE;
        while (right<nums.length){
            while (right<nums.length&&sum<s) {
                sum += nums[right];
                right++;
            }
            //以防整个数组加起来都没s大的情况
            if(sum>=s)
                ans = Math.min(ans,right-left);
            sum -= nums[left];
            left++;
            //以nums数组最后一个元素结尾的情况要在这里讨论，不然会被忽略
            if (right == nums.length&&sum>=s){
                while (sum>=s){
                    sum -= nums[left];
                    left++;
                }
                ans = Math.min(ans,right-left+1);
            }
        }
        return ans<Integer.MAX_VALUE?ans:0;
    }
}
