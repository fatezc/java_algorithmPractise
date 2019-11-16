package practise;
/*
* 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。

每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。

交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。

最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-strings-equal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinimumSwap {
    public int minimumSwap(String s1, String s2) {
        /*
        flag[0]存[x,y]对的数量，flag[1]存[y,x]的数量
        两对[x,y]或者两对[y,x]可通过一次变换到[x,x]+[y,y]
        一对[x,y]+一对[y,x]可以先变换成两对[x,y]再变换到[x,x]+[y,y]，即两次变换
        上述可知，只要flag[0]+flag[1]为偶数，则必然有方法使得这两个字符串相等
         */
        int[] flag = new int[2];
        for (int i = 0; i < s1.length(); i++) {
            flag[0] += s1.charAt(i)>s2.charAt(i)?1:0;
            flag[1] += s1.charAt(i)<s2.charAt(i)?1:0;
        }
        if (flag[0] % 2 +flag[1]%2 ==1)//判断flag[0]+flag[1]是不是奇数
            return -1;
        if (flag[0] % 2 == 0)//如果两个都是偶数
            return flag[0]/2+flag[1]/2;
        return 2+flag[0]/2+flag[1]/2;//如果两个都是奇数
    }
}
