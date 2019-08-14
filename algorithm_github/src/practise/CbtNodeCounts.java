package practise;

/*
* 求完全二叉树的节点个数
* 时间复杂度logn*logn
* */

public class CbtNodeCounts {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int count = 0;//该完全二叉树与对应的满二叉树相差的个数
    /*
    * 判断root的左子树是否为满二叉树,不是则root的右子数必然少了最后一整层,更新count,若是则递归判断右字数
    * */
    public void minus(TreeNode root ,int hight){
        if (hight==1)
        {
            if(root==null)
                count++;
            return;
        }
        int lrhight = 0;
        TreeNode lr = root.left;
        while (lr!=null){
            lrhight++;
            lr = lr.right;
        }
        if (lrhight < hight-1)
        {
            count += (int)Math.pow(2,hight-2);
            minus(root.left,hight-1);
        }
        else minus(root.right,hight-1);
    }
    public int countNodes(TreeNode root) {
        int treehigh = 0;
        if (root==null)
            return 0;
        TreeNode help = root;
        while (help!=null){
            ++treehigh;
            help = help.left;
        }
        minus(root,treehigh);
        return (int)Math.pow(2,treehigh)-1-count;
    }
}
