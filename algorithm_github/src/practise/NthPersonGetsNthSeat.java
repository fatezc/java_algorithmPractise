package practise;
/*
* 有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。

剩下的乘客将会：

如果他们自己的座位还空着，就坐到自己的座位上，

当他们自己的座位被占用时，随机选择其他座位
第 n 位乘客坐在自己的座位上的概率是多少？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/airplane-seat-assignment-probability
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NthPersonGetsNthSeat {
    public double nthPersonGetsNthSeat(int n) {
        /*
        1.动态规划
很容易想到，如果第一个人正好坐在自己的位置，那么之后所有的人都会坐在自己的位置。
如果第一个人正好坐在第n个人的位置，那么第n个人没可能坐在自己的位置。
如果第一个人坐在第k个位置，其中1<k<n，那么第2~k-1个人会按自己的票来坐，相当于dp[k]
所以转移方程为: dp[i] = 1 / i + 1 / i(dp[i-1] + dp[i-2] + ... dp[2])
上式可根据数学归纳法得出当dp >= 2 时dp[i] = 0.5
作者：virginiadb-Y0WqAUJ773
链接：https://leetcode-cn.com/problems/airplane-seat-assignment-probability/solution/dong-tai-gui-hua-fa-he-shu-xue-fa-by-virginiadb-y0/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        return n > 1?0.5:1.0;
    }
}
