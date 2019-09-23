package practise;
/*
* 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

数学表达式如下:

如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IncreasingTriplet {
    /*
    添加两个遍历存最小值和次小值，每次更新
    可能会出现在次小值右侧出现比最小值还小的值，依然将最小值更改为此值，不影响最终结果
    如:4516,虽然更新到1时，最小值1次小值5右侧，但如果在更右侧出现了比次小值大的数，则仍然满足原来的456
    此外，如：45123，这种情况时，也不会漏掉123
     */
    public boolean increasingTriplet(int[] nums) {
            int min_first = Integer.MAX_VALUE;
            int min_second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num>min_second)
                return true;
            if (num<=min_first)
                min_first = num;
            else if (num< min_second)
                min_second = num;
        }
        return false;
    }
}
