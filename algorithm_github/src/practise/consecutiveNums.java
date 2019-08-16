package practise;

import java.util.Arrays;
import java.util.Comparator;
/*
* 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
* */
public class consecutiveNums {

    public int consecutiveNumbersSum(int N) {
        int n = (int)Math.sqrt(N*2);
        int ans = 1,sum = 1;
        for (int i = 2; i <=n ; i++) {
            sum += i;//sum = 1+2+3+...+i
            if ((N-sum)%i == 0)//N-sum为i的整数倍表示可以将N表示为k+1~k+i,其中k为(N-sum)/i
                ans++;
        }
        return ans ;
    }

    public static void main(String[] args) {
        System.out.println(new consecutiveNums().consecutiveNumbersSum(5));
    }
}
