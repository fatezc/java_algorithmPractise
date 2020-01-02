package practise;
/*
* 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和。
* */
public class TotalHammingDistance {
    /*
    计算每一位上nums中1的个数one，那么那一位上所有数亦或出来的1的数量为one*(n*one)
     */
    public int totalHammingDistance(int[] nums) {
        int one ;
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            one = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]>0){
                    one += (nums[j] & 1);
                    nums[j] >>= 1;
                }
            }
            ans += one*(nums.length-one);
        }
        return ans;
    }
}
