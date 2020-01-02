package practise;

import java.util.Arrays;
import java.util.Comparator;

/*
* 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。

视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。

我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/video-stitching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class VideoStitching {
    /*
    先按照开始时间升序排序，然后每次都选取能使已经包含的时间段的右端尽量大即可
     */
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int  right = 0;
        int i = 0;
        int ans = 0;
        while (right<T){
            int lager_right = 0;
            while (i<clips.length && clips[i][0]<=right){
                lager_right = Math.max(lager_right,clips[i][1]);
                ++i;
            }
            //如[[0,2],[4,8]],在第一次循环后larger_right不变，无法跳出循环
            if (right == lager_right)
                return -1;
            right = lager_right;
            ++ans;
            if (i == clips.length && right<T)
                return -1;
        }
        return ans;
    }
}
