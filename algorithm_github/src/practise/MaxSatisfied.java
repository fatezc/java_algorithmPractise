package practise;
/*
* 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。

在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。

书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。

请你返回这一天营业下来，最多有多少客户能够感到满意的数量。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        //先统计不生气时的顾客数，计入ans,并将此时的customer[i]置为0
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0){
                ans += customers[i];
                customers[i] = 0;
            }
        }
        //那么此时customer就表示感到不满意的顾客数，原地转换为前缀和
        for (int i = 0; i < customers.length; i++) {
            if (i>0)
                customers[i] += customers[i-1];
        }
        //然后求出最多能让多少位不满意转换为满意即可
        int max = customers[X-1];
        for (int i = X; i <customers.length ; i++) {
            max = Math.max(max,customers[i] - customers[i-X]);
        }
        return ans+max;
    }
}
