package practise;
/*
* 根据一棵树的中序遍历与后序遍历构造二叉树。
* 假设没有相同元素
* */
public class BuildTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null||postorder == null||inorder.length == 0||postorder.length == 0)
            return null;
        TreeNode ans = helpBuild(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return ans;
    }
    public TreeNode helpBuild(int[] inoeder ,int inleft,int inright,int[] postorder ,int postleft,int postright){
        if (inleft>inright||postleft>postright)
            return null;
        if (inleft == inright && postleft == postright)
            return new TreeNode(inoeder[inleft]);
        TreeNode root = new TreeNode(postorder[postright]);
        int count = 0;//count代表左子树有多少个节点
        for (int i = inleft; i <= inright; i++) {
            if (inoeder[i] == postorder[postright])
                break;
            ++count;
        }
        root.left = helpBuild(inoeder,inleft,inleft+count-1,postorder,postleft,postleft+count-1);
        root.right = helpBuild(inoeder,inleft+count+1,inright,postorder,postleft+count,postright-1);
        return root;
    }
}
