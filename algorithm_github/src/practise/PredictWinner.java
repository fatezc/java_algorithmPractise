package practise;
/*
* 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
如果最终两个玩家的分数相等，那么玩家1仍为赢家。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/predict-the-winner
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class PredictWinner {
    /*
    * dp[i][j]表示从nums[i]到nums[j]先手比另一位玩家多的最大分数，最后返回dp[0][nums.length-1]是否大于0即可

对于dp[i][j]，如果先手拿了nums[i]，则另一位玩家比先手多dp[i+1][j]，dp[i][j] = nums[i]-dp[i+1][j]，
* 如果先手拿了nums[j]，则另一位玩家比先手多dp[i][j-1]，dp[i][j] = nums[j]-dp[i][j-1]
综上，dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1])
当i=j时，先手一定赢，比另一位玩家多dp[i][j]=nums[i]
    * */
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length<2)
            return true;
        int[][] dp = new int[nums.length][nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
            sum+=nums[i];
        }
        for (int j = 1; j <dp.length ; j++) {
            for (int i = j-1; i >=0 ; i--) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }
}
