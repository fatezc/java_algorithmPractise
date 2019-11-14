package practise;
/*
* 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

示例 1:

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxProfit {
    /*
    我们维护两个变量 \mathrm{cash}cash 和 \mathrm{hold}hold，前者表示当我们不持有股票时的最大利润，后者表示当我们持有股票时的最大利润。

在第 ii 天时，我们需要根据第 i - 1i−1 天的状态来更新 \mathrm{cash}cash 和 \mathrm{hold}hold 的值。对于 \mathrm{cash}cash，我们可以保持不变，或者将手上的股票卖出，状态转移方程为

cash = max(cash, hold + prices[i] - fee)
对于 \mathrm{hold}hold，我们可以保持不变，或者买入这一天的股票，状态转移方程为

hold = max(hold, cash - prices[i])

作者：LeetCode
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-shou-xu-fei-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = cash;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
