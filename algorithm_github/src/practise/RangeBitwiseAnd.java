package practise;
/*
* 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
* */
public class RangeBitwiseAnd {
    /*
    当m == n时,返回m
    当m<n时,则必然存在m+1,而m和m+1的二进制末位肯定不一样,即相与之后二进制末位必然为0
    每次比较m和n,如果m<n ,则都右移一位,直到m==n
     */
    public int rangeBitwiseAnd(int m, int n) {
        int help = 0;//用来记录右移了多少位
        while (n>m){
            help++;
            m = m>>>1;
            n = n>>>1;
        }
        return m<<help;
    }
}
