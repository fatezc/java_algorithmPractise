package practise;
/*在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）

我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。

返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。

如果无法做到，返回 -1.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinDomino {
    public int minDominoRotations(int[] A, int[] B) {
        int count = 0,help = 0;
        //先在A和B中找出可能个数达到A.length的数字help
        for (int i = 0; i < A.length; i++) {
            if (count == 0){
                help = A[i];
                count = 1;
            } else count = A[i] == help?count+1:count-1;
            if (count == 0){
                help = B[i];
                count = 1;
            } else count = B[i] == help?count+1:count-1;
        }
        count = 0;
        for (int i = 0; i < A.length; i++) {
            count = A[i] == help?count+1:count;
            count = B[i] == help?count+1:count;
        }

        //如果,不存在达到A.length的数字,直接返回-1
        if (count<A.length)
            return -1;

        //然后在A和B中同级help的出现次数
        int Ahelp = 0,Bhelp = 0;
        for (int i = 0; i < A.length; i++) {
            //如果某一对都没有help则返回-1
            if (A[i] != help && B[i] != help)
                return -1;
            if (A[i] == help)
                Ahelp++;
            if (B[i] == help)
                Bhelp++;
        }
        return A.length - Math.max(Ahelp,Bhelp);
    }
}
