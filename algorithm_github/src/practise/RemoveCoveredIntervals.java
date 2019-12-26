package practise;

import java.util.Arrays;
import java.util.Comparator;

/*
* 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。

只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。

在完成所有删除操作后，请你返回列表中剩余区间的数目。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-covered-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class RemoveCoveredIntervals {
    /*
    排序，遍历，用remove[]来存储是否删除
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        boolean[] remove = new boolean[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (remove[i])
                continue;
            for (int j = i+1; j <intervals.length ; j++) {
                if (intervals[j][0]>intervals[i][1])
                    break;
                if (intervals[j][1]<=intervals[i][1])
                    remove[j] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < remove.length; i++) {
            ans = ans + (remove[i]?0:1);
        }
        return ans;
    }
}
