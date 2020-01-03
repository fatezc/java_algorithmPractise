package practise;
/*
* 在显示着数字的坏计算器上，我们可以执行以下两种操作：

双倍（Double）：将显示屏上的数字乘 2；
递减（Decrement）：将显示屏上的数字减 1 。
最初，计算器显示数字 X。

返回显示数字 Y 所需的最小操作数
提示：

1 <= X <= 10^9
1 <= Y <= 10^9
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/broken-calculator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class BrokenCalc {
    /*
    * 除了对 X 执行乘 2 或 减 1 操作之外，我们也可以对 Y 执行除 2（当 Y 是偶数时）或者加 1 操作。

这样做的动机是我们可以总是贪心地执行除 2 操作：

当 Y 是偶数，如果先执行 2 次加法操作，再执行 1 次除法操作，我们可以通过先执行 1 次除法操作，再执行 1 次加法操作以使用更少的操作次数得到相同的结果 [(Y+2) / 2 vs Y/2 + 1]。

当 Y 是奇数，如果先执行 3 次加法操作，再执行 1 次除法操作，我们可以将其替代为顺次执行加法、除法、加法操作以使用更少的操作次数得到相同的结果 [(Y+3) / 2 vs (Y+1) / 2 + 1]。

算法

当 Y 大于 X 时，如果它是奇数，我们执行加法操作，否则执行除法操作。之后，我们需要执行 X - Y 次加法操作以得到 X。

作者：LeetCode
链接：https://leetcode-cn.com/problems/broken-calculator/solution/pi-liao-de-ji-suan-qi-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (Y>X){
            if (Y%2 == 0)
                Y = Y/2;
            else Y = Y+1;
            ++count;
        }
        return count+X-Y;
    }
}
