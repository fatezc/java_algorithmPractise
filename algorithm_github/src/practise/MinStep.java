package practise;
/*
* 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：

Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
Paste (粘贴) : 你可以粘贴你上一次复制的字符。
给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/2-keys-keyboard
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinStep {
/*
将n拆成i*j,那么n个'A'可由先得到i个'A',然后复制黏贴j-1遍得到
 */
    public int minSteps(int n) {
       if (n==1)
           return 0;
       int ans = n;//对应将一个A复制,然后黏贴n-1遍的情况

        for (int i = 2; i <n ; i++) {
            if (n%i==0){
                int j = n/i;
                //情况1:先得到j个A,然后复制黏贴i-1遍
                ans = Math.min(ans,i+minSteps(j));
                //情况2:先得到i个A,然后复制黏贴j-1遍
                ans = Math.min(ans,j+minSteps(i));
            }
        }
        return ans;
    }
}
