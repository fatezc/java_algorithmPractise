package practise;

import java.util.Arrays;

/*
* 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。

在此过程之后，我们得到一些数组 B。

返回 B 的最大值和 B 的最小值之间可能存在的最小差值

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/smallest-range-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SmallestRangeII {

    /*
一.算法证明,假定A已经排好序,N是数组A的长度
1.令B = [A[0]+K,....,A[j]+K,...,A[i]+K,A[i+1]-K,...,...A[N-1]-K]，
B' = [A[0]+K,....,A[j]-K,...,A[i]+K,A[i+1]-K,...,...A[N-1]-K],
因为A[j]+K<A[i]+K并且，A[j]+K>A[j-1]+k，所以，令A[j]-K变成A[j]+K
不会使B的区间长度变大，A数组中对 每一个下标在0~i之间的元素都是如此，
包括0；也就是，如果存在A[i] 应该+K，那么i之前的数全都可以+K
2.令B = [A[0]+K,....,A[j]+K,...,A[i]+K,A[i+1]-K,...,...A[N-1]-K]，
B' = [A[0]+K,....,A[i]+K,A[i+1]-K,...,A[j]+K,...A[N-1]-K],同理，
令A[j]+K变成A[j]-K也不会使B数组区间的长度变大，那么如果存在一个i有A[i]-K，
那么i+1~N-1之间的元素全部都可以-K，包括下标为N-1的元素
3.由前面两点知道，关键是找出+K与-K的分界点的下标是多少.假定下标为h，那么就是A[0]+K,A[N-1]-K,A[h]+K,A[h+1]-K四个值决定了数组B区间长度的大小；
4.如果这个分界点是0，代表全-K，如果这个分界点是N-1，代表权+K，全加和全减的区间长度都是A[N-1]-A[0]，故将ans的初始值设为A[N-1]-A[0]就行了.

作者：codebrick
链接：https://leetcode-cn.com/problems/smallest-range-ii/solution/leetcodeguan-fang-ti-jie-zhong-wen-fan-yi-li-mian-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int ans = A[A.length-1]-A[0];
        for (int i = 0; i < A.length-1; i++) {
            int high = Math.max(A[i]+K,A[A.length-1]-K);
            int low = Math.min(A[i+1]-K,A[0]+K);
            ans = Math.min(ans,high-low);
        }
        return ans;
    }
}
