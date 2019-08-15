package practise;

/*
当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

        若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
        或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
        也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

        返回 A 的最大湍流子数组的长度。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class TurbulenSize {


    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        if (len<=1)
            return len;
        int ans = 0;
        int compare[] = new int[len-1];
        //compare[i]记录A[i+1]-A[i]的符号
        for (int i = 0; i < len-1; i++) {
            if (A[i+1]-A[i]>0)
                compare[i] = 1;
            if (A[i+1]-A[i]<0)
                compare[i] = -1;
        }
        int l =-1;
        /*
        * compare[l+1~r]表示符合湍流的符号个数,对于每一个满足湍流的子数组,它的子数组也必然满足要求,
        * 故当compare[l+1~r]不满足时,直接令l = r-1;
        * */
        for (int r = 0; r < len - 1; r++) {
            if (compare[r] == 0)//不满足要求
                l = r++;
            else if (r-l==1)//避免r-1<0的情况
                ans = Math.max(ans,1);
            else if (compare[r] == compare[r-1])
                l = r-1;
            else ans = Math.max(ans,r-l);
        }
        return ans+1;
    }
}
