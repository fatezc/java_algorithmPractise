package practise;

import java.util.TreeMap;
/*
* 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。

对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。

注意:

你可以假设区间的终点总是大于它的起始点。
你可以假定这些区间都不具有相同的起始点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-right-interval
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0],i);
        }
        for (int i = 0; i < intervals.length; i++) {
            if (map.ceilingKey(intervals[i][1])!=null)
                ans[i] = map.get(map.ceilingKey(intervals[i][1]));
            else ans[i] = -1;
        }
        return ans;
    }
}
