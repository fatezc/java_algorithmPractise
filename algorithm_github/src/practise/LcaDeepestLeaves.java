package practise;

public class LcaDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (depth(root.left) == depth(root.right))
            return root;
        if (depth(root.left)>depth(root.right))
            return lcaDeepestLeaves(root.left);
        if (depth(root.right)>depth(root.left))
            return lcaDeepestLeaves(root.right);
        return null;
    }
    //计算节点的最大深度
    public int depth(TreeNode root){
        if (root == null)
            return 0;
        return 1 + Math.max(depth(root.left),depth(root.right));
    }
}
