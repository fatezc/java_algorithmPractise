package practise;
/*
* 给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。

如果无法这么操作，就请返回原数组。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/previous-permutation-with-one-swap
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class PrevPermOpt1 {
    public int[] prevPermOpt1(int[] A) {
        //先找到从左到右第一个右边有比它小的数的数，标记位置为help
        int help ,min = A[A.length-1];
        for (help = A.length-2;help>=0;--help){
            if (A[help]>min)
                break;
            min = Math.min(min,A[help]);
        }
        if (help==-1)
            return A;
        //然后找到help右边比A[help]小的数中值最大，位置最靠左的数交换二者即可
        int max_cur = help;
        for (int i = A.length - 1; i > help; i--) {
            if (A[i]<A[help]){
                if (max_cur == help || A[i]>=A[max_cur])
                    max_cur = i;
            }
        }
        int temp = A[help];
        A[help] = A[max_cur];
        A[max_cur] = temp;
        return A;
    }
}
