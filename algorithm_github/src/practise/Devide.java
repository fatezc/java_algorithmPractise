package practise;

import org.w3c.dom.ls.LSOutput;

public class Devide {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor ==-1)
            return Integer.MAX_VALUE;
        boolean flag;
        if ((dividend>0&&divisor>0)||(dividend<0&&divisor<0))
            flag = true;
        else flag = false;
        dividend = dividend<0?dividend:-dividend;
        divisor = divisor<0?divisor:-divisor;
        int ans = 0;
        for (int i = 31; i >= 0 &&dividend<=divisor ; i--) {
            if (dividend ==  divisor)
            {
                ans--;
                dividend = 0;
                break;
            }
            if ((dividend>>i)<=divisor-1){
                ans -= 1<<i;
                dividend -= divisor<<i;
            }
        }
        if (dividend ==  divisor)
        {
            ans--;

        }
        return flag?-ans:ans;
    }


    public static void main(String[] args) {

       int a =  new Devide().divide(-2147483648,Integer.MIN_VALUE);
        System.out.println(a);
    }
}
