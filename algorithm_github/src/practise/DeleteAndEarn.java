package practise;

import java.util.*;

/*
* 给定一个整数数组 nums ，你可以对它进行一些操作。

每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。

开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
* 注意:

nums的长度最大为20000。
每个整数nums[i]的大小都在[1, 10000]范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-and-earn
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class DeleteAndEarn {
    /*
    先用hashmap统计每个数字出现的次数，然后将原数组转换成dp,其中dp[i][0]表示nums中的数字，dp[i][1]为该数字出现的次数
    然后对dp按照dp[i][0]排序，用dp[i][2]来进行动态规划，dp[i][2]代表从0~i位置，最多能拿多少分
    则每到位置i，如果dp[i][0]>dp[i-1]+1，则完全无影响，可以直接加
                否则分两种情况，使用dp[i]和不使用dp[i]分别对用dp[i-2][2]+dp[i][0]*dp[i][1]和dp[i-1][2],取最大值即可
     */
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> set = map.keySet();
        int dp[][] = new int[set.size()][3];
        int i = 0;
        for (Integer integer : set) {
            dp[i][0] = integer;
            dp[i][1] = map.get(integer);
            ++i;
        }
        Arrays.sort(dp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        dp[0][2] = dp[0][1]*dp[0][0];
        if (dp.length>1){
            if (dp[1][0] > dp[0][0]+1)
                dp[1][2] = dp[0][2]+dp[1][0]*dp[1][1];
            else dp[1][2] = Math.max(dp[0][2],dp[1][0]*dp[1][1]);
        }
        for (int j = 2; j <dp.length ; j++) {
            if (dp[j][0]>dp[j-1][0]+1)
                dp[j][2] = dp[j-1][2]+dp[j][0]*dp[j][1];
            else dp[j][2] = Math.max(dp[j-2][2]+dp[j][0]*dp[j][1],dp[j-1][2]);
        }
        return dp[dp.length-1][2];
    }
}
