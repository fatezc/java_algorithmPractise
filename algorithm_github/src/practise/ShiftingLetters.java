package practise;
/*
* 有一个由小写字母组成的字符串 S，和一个整数数组 shifts。

我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。

例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。

对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。

返回将所有这些移位都应用到 S 后最终得到的字符串。
* 提示：

1 <= S.length = shifts.length <= 20000
0 <= shifts[i] <= 10 ^ 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shifting-letters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        int[] help = new int[S.length()];
        help[shifts.length-1] += shifts[shifts.length-1];
        help[shifts.length-1] %= 26;
        //从后往前遍历只需要遍历一遍
        for (int i = shifts.length-2; i >= 0; i--) {
            help[i] += help[i+1]+shifts[i];
            help[i] %= 26;
        }
        char[] ans = new char[help.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char)((S.charAt(i)-'a'+help[i])%26+'a');
        }
        return String.valueOf(ans);
    }
}
