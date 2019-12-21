package practise;
/*
* 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null ||(root.val == key && root.left == null &&root.right == null))
            return null;
        TreeNode p = root,pre = root;
        //先找到要删除的节点和它的前驱节点
        while (p.val != key){
            pre = p;
            if (p.val>key){
                if (p.left == null)
                    return root;
                p = p.left;
            }else {
                if (p.right == null)
                    return root;
                p = p.right;
            }
        }
        //如果该节点有孩子，那么每次与它左子树的最右节点，或者右子树的最左节点交换，直到没有孩子，删除该节点
       while (p.left!=null||p.right!=null){
           TreeNode cur = p;
           pre = p;
           if (p.left!=null){
               p = p.left;
               while (p.right!=null){
                   pre = p;
                   p = p .right;
               }
               int temp = cur.val;
               cur.val = p.val;
               p.val = temp;
           }else {
               p = p .right;
               while (p.left!=null){
                   pre = p;
                   p = p.left;
               }
               int temp = cur.val;
               cur.val = p.val;
               p.val = temp;
           }
       }
       if (pre.left == p)
           pre.left = null;
       else pre.right = null;
       return root;
    }
}
