package practise;

import java.util.LinkedList;
import java.util.List;
/*
* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Combine {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {

        if (curr.size() == k)
            output.add(new LinkedList(curr));

        for (int i = first; i < n + 1; ++i) {

            curr.add(i);

            backtrack(i + 1, curr);

            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }
}
