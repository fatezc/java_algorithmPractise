package practise;
/*
* 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。

(回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class BstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode help = help(preorder, 0, preorder.length);
        return help;
    }
    public TreeNode help(int[] preorder,int left,int right){
        if (left>right)
            return null;
        TreeNode ans = new TreeNode(preorder[left]);
        int i = left+1;
        while (i<=right && preorder[i]<preorder[left]) ++i;
        TreeNode L = help(preorder, left + 1, i - 1);
        TreeNode R = help(preorder, i, right);
        ans.left = L;
        ans.right = R;
        return ans;
    }
}
