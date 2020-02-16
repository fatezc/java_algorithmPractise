package practise;
/*
* 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
* 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
* */
public class SingleNumbers {
    /*
    运用a^a = 0; 0^a = a;
    假设两数为a和b,先将整个数组抑或得到的就是a^b
    在找到a^b的二进制中为1的某位,即a和b在该位上不同
    然后再遍历数组,当该位为0则与ans[0]抑或,该位为1则与ans[1]抑或
    最后ans[0]和ans[1]就是a和b
     */
    public int[] singleNumbers(int[] nums) {
        int [] ans = new int[2];
        int help = 0;
        for (int num : nums) {
            help ^= num;
        }
        int i = 1;
        for ( ; i < 32; i++) {
            if ((help & 1) == 1)
                break;
            help >>= 1;
        }
        help = 1;
        for (int j = 1; j < i; j++) {
            help <<= 1;
        }
        for (int num : nums) {
            if ((num & help) != 0)
                ans[0] ^= num;
            else ans[1] ^=num;
        }
        return ans;
    }
}
