package practise;

import java.util.HashSet;
/*
* 在桌子上有 N 张卡片，每张卡片的正面和背面都写着一个正数（正面与背面上的数有可能不一样）。

我们可以先翻转任意张卡片，然后选择其中一张卡片。

如果选中的那张卡片背面的数字 X 与任意一张卡片的正面的数字都不同，那么这个数字是我们想要的数字。

哪个数是这些想要的数字中最小的数（找到这些数中的最小值）呢？如果没有一个数字符合要求的，输出 0。

其中, fronts[i] 和 backs[i] 分别代表第 i 张卡片的正面和背面的数字。

如果我们通过翻转卡片来交换正面与背面上的数，那么当初在正面的数就变成背面的数，背面的数就变成正面的数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/card-flipping-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ConvertCard {
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> set = new HashSet<>();
        //将正反面相同的数存入set,那么不在set中的数必然可以通过翻牌使其满足题意
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i])
                set.add(fronts[i]);
        }
        int ans = 2001;
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i]<ans && !set.contains(fronts[i]))
                ans = fronts[i];
            if (backs[i]<ans && !set.contains(backs[i]))
                ans = backs[i];
        }
        return ans==2001?0:ans;
    }
}
