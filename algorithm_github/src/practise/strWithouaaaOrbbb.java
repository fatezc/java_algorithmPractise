package practise;

/*给定两个整数 A 和 B，返回任意字符串 S，要求满足：

        S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
        子串 'aaa' 没有出现在 S 中；
        子串 'bbb' 没有出现在 S 中。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/string-without-aaa-or-bbb
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class strWithouaaaOrbbb {
    public String strWithout3a3b(int A, int B) {
        char [] chars = new char[A+B];
        int i = 0;

        if (A>B&&B>0){
            //A>B则字符串以aab的形式开头
            while (A>B&&B>0){
                chars[i++] = 'a';
                chars[i++] = 'a';
                chars[i++] = 'b';
                A -=2;
                B -=1;
            }
            //后面的以ab的形式
            while (A==B&&B>0){
                chars[i++] = 'a';
                chars[i++] = 'b';
                --A;--B;
            }
        }
        //同上,只是ab互换
        if (A<B&&A>0){
            while (A<B&&A>0){
                chars[i++] = 'b';
                chars[i++] = 'b';
                chars[i++] = 'a';
                B -=2;
                A -=1;
            }
            while (A==B&&B>0){
                chars[i++] = 'b';
                chars[i++] = 'a';
                --A;--B;
            }
        }
        //A==B时直接ababab...
        if (A==B&&B>0){
            while (A==B&&B>0){
                chars[i++] = 'a';
                chars[i++] = 'b';
                --A;--B;
            }
        }
        //B==0
        while (A>0)
        {
            chars[i++] = 'a';
            A--;
        }
        //A==0
        while (B>0)
        {
            chars[i++] = 'b';
            B--;
        }
        return String.valueOf(chars);
    }
}
