package practise;
/*在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

        如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

        说明: 

        如果题目有解，该答案即为唯一答案。
        输入数组均为非空数组，且长度相同。
        输入数组中的元素均为非负数。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/gas-station
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处*/
public class CanCompeleteCircle {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        /**
         * 用滑动窗口法,left,right分别为左右指针,gassum,costsum为窗口内gas总量和cost总量,realright为将数组视为一个圈时实际的right位置
         */
        int left = 0,right = 0,gassum = 0,costsum = 0,realrighht = 0;
        while (left<length){
            if (gassum<costsum){
                gassum -= gas[left];
                costsum -= cost[left];
                ++left;
            }else {
                /*当窗口长度为length时返回*/
                if (right - left == length)
                    return left;
                realrighht = right<length?right:right-length;
                gassum += gas[realrighht];
                costsum += cost[realrighht];
                ++right;
            }
        }
        return -1;
    }
}
