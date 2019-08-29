package practise;

import java.util.Comparator;
import java.util.PriorityQueue;

/*有一堆石头，每块石头的重量都是正整数。

        每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

        如果 x == y，那么两块石头都会被完全粉碎；
        如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
        最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/last-stone-weight-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class TheLastStone {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int ans = new TheLastStone().lastStoneWeightII(stones);
        System.out.println(ans);
    }

    /**
     * 由题意知,只需要将stones分为两个最接近stonesWeight/2的两堆,他们的差即为最后所剩
     * 则可将原问题转换为最大容量为stonesWeight/2的背包问题
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        if(stones==null||stones.length==0)
            return 0;
        if (stones.length==1)
            return stones[0];
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int Maxcapcity = sum/2;
        int[] dp = new int[Maxcapcity+1];
        int temp;
        for (int i = 0; i < stones.length; i++) {
            temp = stones[i];
            for (int j = Maxcapcity; j >=0 ; j--) {
                if (j-temp>=0)
                    dp[j] = Math.max(dp[j],dp[j-temp]+temp);
            }
        }
        return sum-2*dp[Maxcapcity];
    }
}
