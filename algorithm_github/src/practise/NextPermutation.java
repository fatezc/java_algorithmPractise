package practise;
/*
* 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NextPermutation {
    /*
    先从右往左找到第一个nums[cur]<nums[cur+1]的元素，然后再在nums中从右到左找第一个比nums[cur]大的元素nums[right]
    交换nums[cur]和nums[right]，再将nums[cur+1:]升序排序，由于此时nums[cur+1:]是降序排序，所以只需要头尾两两对换即可
     */
    public void nextPermutation(int[] nums) {
        int cur = nums.length-2,temp;
        while (cur>=0 && nums[cur]>=nums[cur+1]) --cur;
        if (cur == -1){
            for (int i = 0; i < nums.length / 2; i++) {
                temp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = temp;
            }
            return;
        }
        int right = nums.length-1;
        while (nums[right]<=nums[cur]) --right;
        temp = nums[cur];
        nums[cur] = nums[right];
        nums[right] = temp;
        for (int i = cur+1,j=nums.length-1; i <j ; i++,j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return;
    }
}
