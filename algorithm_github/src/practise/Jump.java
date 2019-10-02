package practise;

import java.util.Arrays;

/*
* 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Jump {
    public int jump(int[] nums) {
        if (nums==null||nums.length==0)
            return 0;
        int[] help = new int[nums.length];
        Arrays.fill(help,Integer.MAX_VALUE);
        help[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <=i+nums[i]&&j<help.length ; j++) {
                help[j] = Math.min(help[j],help[i]+1);
            }
        }
        return help[help.length-1];
    }
}
