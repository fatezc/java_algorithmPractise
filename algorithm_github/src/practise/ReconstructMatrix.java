package practise;

import java.util.ArrayList;
import java.util.List;
/*
* 给你一个 2 行 n 列的二进制数组：

矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
第 0 行的元素之和为 upper。
第 1 行的元素之和为 lower。
第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。

如果有多个不同的答案，那么任意一个都可以通过本题。

如果不存在符合要求的答案，就请返回一个空的二维数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ReconstructMatrix {
    /*
    *

首先我们要明确两点，（1）这道题我们是很容易就能知道是否有解的，（
* 2）当我们确定有解之后，我们很容易构造出来一个符合条件的解的。

对于这道题，当列和为0或者2时，这一列是确定的，只有为1时才会分为两种情况，第一行为1或者第二行为1。对于第（1）点，
* 无解的情况有两种，一是将colsum求和，得到1的总个数，与upper+lower不同，这肯定无解，
* 第二种无解的情况是colsum[i]=2的情况太多，导致某一行的1不够用，这种情况可以通过遍历colsum中2的个数来判断。

除了这两种情况外，这个问题肯定有解，那么我们如何构造一个符合条件的解呢？
* 思路就是把和为0或2的列固定下来，将剩余的列首先把1填到第一行，待到第一行的1的个数达到upper后，
* 再把剩下的列第二行填上1，这样就得到了一个合理的解。
    * */
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0;
        int certain = 0;
        for(int i : colsum) {
            sum += i;
            if(i == 2)
                certain++;
        }
        List<List<Integer>> res = new ArrayList();
        if(sum != upper + lower || upper < certain || lower < certain)
            return res;
        res.add(new ArrayList<Integer>());
        res.add(new ArrayList<Integer>());
        upper -= certain;
        lower -= certain;
        for(int i = 0; i < colsum.length; i++) {
            if(colsum[i] == 1) {
                if(upper > 0) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                } else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                    lower--;
                }
            } else if(colsum[i] == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
            } else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }
        return res;
    }
}
