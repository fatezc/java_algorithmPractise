package practise;
/*
* 实现一个函数，检查一棵二叉树是否为二叉搜索树
* */
public class IsValidBST {
    /*
    中序遍历,设置一个pre记录每次遍历时的前一个节点的值
    采用long型是为了避免节点值为连续的Int型的最大值或者最小值的情况
     */
    private long pre;
    public boolean isValidBST(TreeNode root) {
        pre = (long)Integer.MIN_VALUE -1 ;
        return mid_search(root);
    }
    public boolean mid_search(TreeNode treeNode){
        if (treeNode == null)
            return true;
        boolean b = mid_search(treeNode.left);
        if (!b)
            return false;
        long v = (long)treeNode.val;
        if (v<pre)
            return false;
        pre = v+1;
        boolean b1 = mid_search(treeNode.right);
        if (!b1)
            return false;
        return true;
    }
}
