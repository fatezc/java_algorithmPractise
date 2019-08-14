package practise;

public class TimorAttack {

    /*在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
    现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
    你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/teemo-attacking
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        if (timeSeries.length==0)
            return 0;
        if (timeSeries.length==1)
            return duration;
        for (int i = 0; i < timeSeries.length-1; i++) {
            if (timeSeries[i+1]-timeSeries[i]>=duration)
                ans += duration;
            else ans += timeSeries[i+1] - timeSeries[i];
        }
        ans += duration;
        return ans;
    }

}
