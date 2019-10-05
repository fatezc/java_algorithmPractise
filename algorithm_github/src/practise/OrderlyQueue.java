package practise;

import java.util.Arrays;

/*
* 给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。

在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。

返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/orderly-queue
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class OrderlyQueue {
    public String orderlyQueue(String S, int K) {
        if (S == null || K == 0 || S.length() == 0)
            return S;
        //当k==1时,可将S看做一个首尾相连的环,从中寻找最小S
        if (K == 1) {
            String ans = S;
            for (int i = 0; i < S.length(); ++i) {
                String T = S.substring(i) + S.substring(0, i);
                if (T.compareTo(ans) < 0) ans = T;
            }
            return ans;
        } else {
            //当K>=2时,可通过操作将任意两个相连位置的值互换,即可完成冒泡排序,即返回由S组成的最小字典序
            //A,i,i+1,B->A,i,B,i+1->A,B,i+1,i->A,i+1,i,B
            char[] ca = S.toCharArray();
            Arrays.sort(ca);
            return new String(ca);
        }
    }

}
