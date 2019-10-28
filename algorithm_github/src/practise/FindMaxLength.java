package practise;

import java.util.HashMap;

/*
* 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
* */
public class FindMaxLength {
    /*
    算法思想：先用sum[i]来保存到i为止1的数量，那么当j-i == 2*(sum[j]-sum[i])时代表i+1~j这一段满足0和1数量相等
    即j-2*sum[j] == i-2*sum[i]
    故用map每次存储i-2*sum[i]最先出现的下标，如果再次出现则可能更新ans
     */
    public int findMaxLength(int[] nums) {
        if (nums == null||nums.length<2)
            return 0;
        int[] sum = new int[nums.length+1];
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
        for (int i = 0; i < sum.length; i++) {
            if (map.containsKey(i-2*sum[i]))
                ans = Math.max(ans,i-map.get(i-2*sum[i]));
            else map.put(i-2*sum[i],i);
        }
        return ans;
    }
}
