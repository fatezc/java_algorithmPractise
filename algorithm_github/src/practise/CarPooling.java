package practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
* 假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。

这儿有一份行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了你的第 i 次行程信息：

必须接送的乘客数量；
乘客的上车地点；
以及乘客的下车地点。
这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。

请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所用乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
示例：
* 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
输出：false
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/car-pooling
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int tripEnd = 0;
        //先求出要送的最远是多长
        for (int i = 0; i < trips.length; i++) {
            tripEnd = Math.max(tripEnd,trips[i][2]);
        }
        //根据出发点升序排序
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Map<Integer,Integer> map = new HashMap<>();
        //对于0~tripEnd中的每个点
        for (int i = 0,j = 0; i <= tripEnd; i++) {
            //如果该点为某些trip的终点，则返回该承载能力
            if (map.containsKey(i)){
                capacity += map.get(i);
                map.remove(i);
            }
            //如果该点出有trip开始
            while (j<trips.length && trips[j][1] == i){
                capacity -= trips[j][0];
                if (capacity<0)
                    return false;
                //map用来存该段trip的结束位置和相对应得占据的承载能力
                map.put(trips[j][2],map.getOrDefault(trips[j][2],0)+trips[j][0]);
                ++j;
            }
        }
        return true;
    }
}
