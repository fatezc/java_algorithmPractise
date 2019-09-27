package practise;

import java.util.Arrays;

/*
* 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/matchsticks-to-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
/*
这一题首先是判断数组和是不是4的倍数，如果不是的话，那一定不能拼成正方形。

然后，遍历一遍数组，若有一个数大于数组和/4，那么也一定不能拼成正方形。

接着就要用回溯来判断了，这题的回溯指的是，把火柴放进不同的边里去。

因此相当于，对于任意一根火柴，将火柴放入大小为4的数组某一维度中去。

直到全部的火柴处理完，在处理过程中，如果某一个边的大小已经超过数组和/4，那就

剪枝，因为这样是不可能组成正方形的。

这里的贪心在于，如果从大到小处理，那么速度将会快的很多。因此在回溯之前，先给数组排序。
*/
public class Makesquare {
    public boolean ans = false;
    public boolean makesquare(int[] nums) {
        if (nums == null||nums.length<4)
            return false;
        int sumlength = 0,len;
        for (int num : nums) {
            sumlength += num;
        }
        if (sumlength%4!=0)
            return false;
        len = sumlength/4;
        for (int num : nums) {
            if (num>len)
                return false;
        }
        int[] temp = new int[4];
        Arrays.sort(nums);
        backtrack(nums.length-1,nums,temp,len);
        return ans;
    }
    public void backtrack(int cur,int[] nums,int[] temp,int target){
        if (ans)
            return ;
        if (cur == -1){
            for (int i : temp) {
                if (i!= target){
                    ans = false;
                    return;
                }
            }
            ans = true;
            return;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] + nums[cur]<=target){
                int help = temp[i];
                temp[i] += nums[cur];
                backtrack(cur-1,nums,temp,target);
                temp[i] = help;
            }
        }
    }
}
