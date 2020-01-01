package practise;
/*
* 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/patching-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinPatches {
    /*
    * 假设数组 arr 添加一个元素即可覆盖 [1, n)内所有数字，那么添加的数字 m 一定满足m <= n。
假设数组 arr 可以覆盖 [1, n) 的所有数字，则给 arr 内加元素 mm：
若m <= n，新数组可以覆盖[1, m + n) = [1, n) ∪ [m, m + n)内所有数字；

作者：jyd
链接：https://leetcode-cn.com/problems/patching-array/solution/patching-array-tan-lan-suan-fa-by-jyd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int minPatches(int[] nums, int n) {
        int ans = 0;
        long right = 1;//右边界，表示如今可以覆盖[0,right)
        int i = 0;
        while (right<=n){
            if (i<nums.length && nums[i]<=right)//如果nums[i]包括在[0,right)内，则可以先通过nums[i]向右扩展
                right += nums[i++];
            else {//否则直接添加right,因为这样可以向右扩展最多
                right *= 2;
                ++ans;
            }
        }
        return ans;
    }
}
