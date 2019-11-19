package practise;

import java.util.Arrays;
import java.util.List;

    /*
    * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
    示例 1：

    输入: ["23:59","00:00"]
    输出: 1


    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/minimum-time-difference
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public class FindMinDifference {
        public int findMinDifference(List<String> timePoints) {
            int[] help = new int[timePoints.size()];
            int i = 0;
            //将输入转换成相应的分钟数
            for (String s : timePoints) {
                help[i] = (s.charAt(0)-'0')*10*60 + (s.charAt(1)-'0')*60 + (s.charAt(3)-'0')*10 + s.charAt(4)-'0';
                ++i;
            }
            Arrays.sort(help);
            int ans = 24*60 - (help[help.length-1] - help[0]);//存在help[i]-help[j]>12*60的情况，此时最小的就是这个值
            for (int j = 0; j < help.length-1; j++) {
                ans = Math.min(ans,help[j+1] - help[j]);
            }
            return ans;
        }
    }


