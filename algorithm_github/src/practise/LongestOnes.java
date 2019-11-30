package practise;
/*
*
* 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

返回仅包含 1 的最长（连续）子数组的长度。*/
public class LongestOnes {
    public int longestOnes(int[] A, int K) {
        int left = 0,right = 0,ans = 0,zeronum = 0;
        while (right<A.length){
            if (A[right] == 0)
                zeronum++;//统计[left,right]内的0的个数
            while (zeronum>K){
                if (A[left] == 0)
                    --zeronum;
                ++left;
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
