package practise;

import java.util.Map;

/*
* 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。

至少有一个空座位，且至少有一人坐在座位上。

亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。

返回他到离他最近的人的最大距离。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxDistToClosest {
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int i = 0,j = seats.length-1;
        while (seats[i] == 0) ++i;
        while (seats[j] == 0) --j;
        ans = Math.max(i,seats.length-1-j);
        int count;
        while (i<j){
            count = 0;
            while (seats[i] == 1&&i<j) ++i;
            while (seats[i] == 0) {
                ++count;
                ++i;
            }
            ans = Math.max(ans,(count+1)/2);
        }
        return ans;
    }
}
