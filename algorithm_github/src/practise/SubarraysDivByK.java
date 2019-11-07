package practise;
//给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
public class SubarraysDivByK {
    public int subarraysDivByK(int[] A, int K) {
        /*
        用help数组存储对于所有的cur<i,所有的sum[0~cur]的和对K取余的值得次数
        help[0~K-2]对应余数为-K+1~-1，help[K-1]对应0，help[K~2K-2]对应1~K-1；
        到位置i时，如果sum%K为正，则除了要增加之前余数等于sum%K的情况，还要增加余数等于sum%K-K的情况，如：K=5，到i的时候sum为2，则要考虑之前sum为-3的情况
        负数同理
         */
        int ans = 0;
        int[] help = new int[2*K-1];
        help[K-1] = 1;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int j = sum%K+K-1;
            if (j>K-1){
                ans += help[j] + help[j-K];
            }
            if (j<K-1){
                ans += help[j] + help[j+K];
            }
            if (j == K-1)
                ans += help[j];
            help[j]++;
        }
        return ans;
    }
}
