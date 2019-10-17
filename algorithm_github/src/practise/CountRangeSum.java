package practise;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-of-range-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null||nums.length==0||lower>upper)
            return 0;
        int  ans = 0;
        //用long类型防止溢出
        long sum = 0;
        Map<Long,Long> map = new HashMap<>();
        map.put(0L,1L);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            for (int j = lower; j <=upper ; j++) {
                ans += map.getOrDefault((long)sum-j,0L);
            }
            map.put((long) sum,map.getOrDefault((long)sum,0L)+1);
        }
        return ans;
    }
}
