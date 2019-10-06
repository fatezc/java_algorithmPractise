package practise;
/*
* 给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
* */
public class MaxPathSum {
    private int ans = Integer.MIN_VALUE;
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return ans;
    }
    /*
    findMaxSum为找到包含root节点的最大路径和，过程为每次沿root.left往下找最大路径和，然后沿root.right往下找最大路径和
    然后将几种情况比较，取最大值
    情况1：只包含root和leftmax
    情况2:只包含root和rightmax
    情况3：包含root和leftmax和rightmax
    情况4;只包含root
    然后更新ans
    返回值也要注意可能只返回root.val
     */
    public int findMaxSum(TreeNode root){
        if (root == null)
            return 0;
        int leftmax = findMaxSum(root.left);
        int rightmax = findMaxSum(root.right);
        ans = Math.max(ans,Math.max(leftmax,Math.max(rightmax,leftmax+rightmax))+root.val);
        ans = Math.max(ans,root.val);
        return Math.max(Math.max(leftmax,rightmax),0)+root.val;
    }

}
