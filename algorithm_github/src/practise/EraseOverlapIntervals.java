package practise;

import java.util.Arrays;
import java.util.Comparator;

/*
* 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-overlapping-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class EraseOverlapIntervals {
    /*
    贪心：每次找到目前最早结束的区间，保留，与其冲突的删去
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int save = 0,lastend = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            while (i<intervals.length && intervals[i][0]<lastend) ++i;
            if (i<intervals.length){
                save++;
                lastend = intervals[i][1];
            }
        }
        return intervals.length-save;
    }
}
