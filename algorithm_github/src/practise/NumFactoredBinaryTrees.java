package practise;

import java.util.*;

/*
* 给出一个含有不重复整数元素的数组，每个整数均大于 1。

我们用这些整数来构建二叉树，每个整数可以使用任意次数。

其中：每个非叶结点的值应等于它的两个子结点的值的乘积。

满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-trees-with-factors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NumFactoredBinaryTrees {
    public int numFactoredBinaryTrees(int[] A) {
        int mod = (int) Math.pow(10,9)+7;
        //现将A排序
        Arrays.sort(A);
        //dp[i]表示以A[i]为根节点的情况下能构成的二叉树数目
        long[] dp =new  long[A.length];
        //将A[i]与相对应的i存入map,方便下面的查找
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i],i);
        }
        long ans = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            //寻找每一个满足构成树的情况
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j]==0 && map.containsKey(A[i]/A[j]))
                    dp[i] += dp[map.get(A[i]/A[j])] * dp[j];
            }
            dp[i] %= mod;
            ans = (ans+dp[i]) %mod;
        }
        return (int) ans;
    }
}
