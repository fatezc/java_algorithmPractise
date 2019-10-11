package practise;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ContainsNearbyAlmostDuplicate {
    /*
    将每个元素按照temp = nums[i]/(T+1)来放入每个组并存入map,遍历过程中对于每一个i,查看map中是否已经有同一个组的,有则返回true
    然后查看temp+1组和temp-1的组,查看是否有满足条件的,有则返回true,其他组则显然不可能有满足条件
    然后放入该元素,删除i-k位置的元素
    本过程中采用Long型数据以防出现极端情况
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k<=0||t<0||nums==null||nums.length<2)
            return false;
        Map<Long,Long> map = new HashMap<>();
        long T = (long)t;
        for (int i = 0; i < nums.length; i++) {
            long temp;
            if (nums[i]>=0)
                temp = (long)nums[i]/(T+1);
            else temp = ((long)nums[i]-T)/(T+1);
            if (map.containsKey(temp))
                return true;
            if (map.containsKey(temp+1)&&map.get(temp+1)-(long)nums[i]<=T)
                return true;
            if (map.containsKey(temp-1)&&(long)nums[i] - map.get(temp-1)<=T)
                return true;
            map.put(temp,(long)nums[i]);
            if (i>=k){
                map.remove((long)nums[i-k]/(T+1));
            }
        }
        return false;
    }

}
