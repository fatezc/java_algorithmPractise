package practise;

public class countbits {
    /*
    *给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回
    * 要求算法的时间复杂度和空间复杂度为O(n)。
    *
    * 解法: 当pow(2,help)<=i<=pow(2,help)-1时ans[i] = help+1-ans[pow(2,help)-1-i]
    * 记cur = pow(2,help)
    * 例如:8<=11<=15,那么ans[11] = 4 - ans[15-11]
    *                  11:1011   15:1111    4:0100
    * */
    public int[] countBits(int num) {
        int [] ans = new int[num+1];
        ans[0] = 0;
        if(num == 0)
            return ans;
        ans[1] = 1;
        int help = 1;
        int cur = 4;
        for (int i = 2; i <ans.length ; i++) {
            if (i>cur-1){
                ++help;
                cur *= 2;
            }

            ans[i] = help+1-ans[cur-1-i];
        }
        return ans;
    }
}
