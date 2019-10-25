package practise;
/*
* 给定两个整数 A 和 B，返回任意字符串 S，要求满足：

S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
子串 'aaa' 没有出现在 S 中；
子串 'bbb' 没有出现在 S 中。

* 提示：

0 <= A <= 100
0 <= B <= 100
对于给定的 A 和 B，保证存在满足要求的 S。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/string-without-aaa-or-bbb
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class StrWithout3a3b {
    public String strWithout3a3b(int A, int B) {
        StringBuilder stringBuilder = new StringBuilder();
        while (A>B){
            if (A>=1){
                stringBuilder.append('a');
                --A;
            }
            if (A>=1){
                stringBuilder.append('a');
                --A;
            }
            if (B>=1){
                stringBuilder.append('b');
                --B;
            }
        }
        while (A<B){
            if (B>=1){
                stringBuilder.append('b');
                --B;
            }
            if (B>=1){
                stringBuilder.append('b');
                --B;
            }
            if (A>=1){
                stringBuilder.append('a');
                --A;
            }
        }
        while (A == B && A>0){
            stringBuilder.append('a');
            stringBuilder.append('b');
            --A;--B;
        }
        return stringBuilder.toString();
    }
}
