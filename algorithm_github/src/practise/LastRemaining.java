package practise;
/*
* 给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字。

示例：

输入:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

输出:
6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/elimination-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class LastRemaining {
    public int lastRemaining(int n) {
        return help(n,1);
    }
    //分为n为奇数、偶数，从前到后、从后到前四种情况
    public int help(int n ,int flag){
        if (n == 1)
            return 1;
        if (flag == 1)
            return 2*help(n/2,-flag);
        if (flag == -1 && n %2 ==1)
            return 2*help(n/2,-flag);
        if (flag == -1 && n%2 == 0)
            return 2*help(n/2,-flag) - 1;
        return 1;
    }
}
