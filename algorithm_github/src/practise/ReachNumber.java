package practise;
/*
* 在一根无限长的数轴上，你站在0的位置。终点在target的位置。

每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。

返回到达终点需要的最小移动次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reach-a-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ReachNumber {
    /*
    只需考虑一边即可
    最后target = sum[往右走的步数] - sum[往左走的步数] = sum[1~k] - 2*sum[往左走的步数]
    也就是说找到第一个满足(sum[1~k]-target)是二的倍数的K即可
     */
    public int reachNumber(int target) {
        target = target <0?target:-target;
        int ans = 1;
        while (target<0 || target %2 !=0){
            target += ans++;
        }
        return ans-1;
    }

}
