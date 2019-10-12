package practise;
/*
* 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
* */
public class SuperPow {
    //将a拆成x*1337+y,则只需要考虑y的部分
    public int superPow(int a, int[] b) {
        int mod = 1337;
        int ans = 1;
        a = a % mod;
        if (a==1)
            return 1;
        int[] help = new int[b.length];
        help[0] = a;
        for (int i = 1; i < help.length; i++) {
            help[i] = help[i-1];
            for (int j = 0; j < 9; j++) {
                help[i] *= help[i-1];
                help[i] %= mod;
            }
        }
        for (int i = 0; i < help.length; i++) {
            if (b[b.length-1-i]!=0){
                int temp =help[i];
                for (int j = 0; j < b[b.length - 1 - i]-1; j++) {
                    help[i] *= temp;
                    help[i] %= mod;
                }
                ans *= help[i];
                ans %= mod;
            }
        }
        return ans;
    }
}
