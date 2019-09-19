package practise;
/*
* 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
* */
public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int[] ans = {0,0};
        if (nums == null||nums.length<2)
            return null;
        int help = nums[0];
        /*
        假设最后返回a和b,由于x^x = 0,故将整个数组做异或运算后得到的help = a^b
         */
        for (int i = 1; i < nums.length; i++) {
            help ^= nums[i];
        }
        int sign = 0;
        /*
        然后找到help二进制表现形式中最后一个1,则a和b在该位必然不同,则可以按该位将原数组分为两组
         */
        for (int i = 0; i < 32; i++) {
            if ((help & 1) == 1){
                sign = i;
                break;
            }else{
                help = help>>1;
            }
        }
        /*
        两组里分别进行抑或运算,则分别能得到a和b
         */
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]>>sign & 1) == 1)
                ans[0] ^= nums[i];
            else ans[1] ^= nums[i];
        }
        return ans;
    }
}
