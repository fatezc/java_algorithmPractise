package practise;
/*
* 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）

现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。

返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class AtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int ans = 0;
        String Nstr = ""+N;
        //假设N是n位数，则下面这个循环先考虑了1~n-1位数的情况，因为1~n-1位数必然小于n位数
        for (int i = 1; i <= Nstr.length()-1 ; i++) {
            ans += (Math.pow(D.length,i));
        }
        /*
        接下来计算满足条件的n位数
         */
        for (int i = 0; i < Nstr.length(); i++) {
            //如果N的第i位数比D中最大的要大，则从第i位开始可以任意填充
            if (D[D.length-1].toCharArray()[0]<Nstr.charAt(i)){
                ans += (int)Math.pow(D.length,Nstr.length()-i);
                break;
            }
            //否则
            for (int j = 0; j < D.length; j++) {
                //如果存在D[j]==N[i]，则仍需要考虑i位之后的情况
                if (Nstr.charAt(i) == D[j].toCharArray()[0]){
                    ans += j*(int)Math.pow(D.length,Nstr.length()-i-1);
                    //D[j]==N[i]，且i已经到了最后一位，说明可以去到等于N的数，答案加1
                    if ( i == Nstr.length()-1)
                        ans ++;
                    //终止内层循环
                    j = D.length;
                }
                //如果不存在D[j] == N[i],则不需要考虑i为之后的情况
                else if (Nstr.charAt(i)<D[j].toCharArray()[0]){
                    ans += j*(int)Math.pow(D.length,Nstr.length()-i-1);
                    //终止内、外层循环
                    j = D.length;
                    i = Nstr.length();
                }
            }
        }
        return ans;
    }
}
