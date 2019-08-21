package practise;

public class cutZeroTreeBranch {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
/*
* 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。

返回移除了所有不包含 1 的子树的原二叉树。
* */
    public TreeNode pruneTree(TreeNode root) {
        cutTree(root);
        return root;
    }

    public void cutTree(TreeNode root){
        if(root == null)
            return;
        cutTree(root.left);
        cutTree(root.right);
        //减去左右子树中被设为-1的枝
        if(root.left!=null&&root.left.val == -1)
            root.left = null;
        if(root.right!=null&&root.right.val == -1)
            root.right = null;
        //遇到需要减的枝,将值设为-1
        if(root.left == null && root.right == null && root.val == 0)
            root.val = -1;

    }

}
