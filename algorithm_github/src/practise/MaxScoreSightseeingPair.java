package practise;
/*
* 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

返回一对观光景点能取得的最高分

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-sightseeing-pair
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxScoreSightseeingPair {
    /*
    A[i] + A[j] + i - j = A[i]-i + A[j]-j +2*i
     */
    public int maxScoreSightseeingPair(int[] A) {
        //先将A[i]变为A[i]-i
        for (int i = 0; i < A.length; i++) {
            A[i] -= i;
        }
        //right_max记录对于每一个A[i],其右边最大的A[j]
        int right_max = A[A.length-1];
        int ans = 0;
        for (int i = A.length-2; i >=0 ; i--) {
            //对于每一个i,此时的A[i]+right_max+2*i就等于原来的A[i] + A[j] + i - j中最大的那一个
            ans = Math.max(ans,A[i]+right_max+2*i);
            //更新right_max
            right_max = Math.max(right_max,A[i]);
        }
        return ans;
    }
}
