package practise;
/*
* 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。

对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

以 10^9 + 7 为模，返回这些数字之和。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SumRootToLeaf {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  private int ans  = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root!=null)
            preserch(root,0);
        return ans;
    }
    public void preserch(TreeNode root,int pre){
        if (root.left == null&&root.right == null){
            ans += (pre<<1)+root.val;
            return;
        }
        if (root.left!=null)
            preserch(root.left,(pre<<1)+root.val);
        if (root.right!=null)
            preserch(root.right,(pre<<1)+root.val);
    }
}
