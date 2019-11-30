package practise;
/*
* 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。

给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-similar-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class KSimilarity {
    public int kSimilarity(String A, String B) {
        return help(A.toCharArray(),B.toCharArray(),0);
    }
    //递归求解
    public int help(char[] A,char[] B,int cur){
        if (cur == A.length)
            return 0;
        if (A[cur] == B[cur])
            return help(A,B,cur+1);
        int min = Integer.MAX_VALUE;
        for (int i = cur+1; i <A.length ; i++) {
            if (A[i] == B[cur]){
                char temp = A[i];
                A[i] = A[cur];
                A[cur] = temp;
                min = Math.min(min,help(A,B,cur+1));
                temp = A[i];
                A[i] = A[cur];
                A[cur] = temp;
            }
        }
        return 1+min;
    }
}
