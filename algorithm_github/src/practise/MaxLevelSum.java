package practise;

import java.util.LinkedList;

/*
* 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。

请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MaxLevelSum {
    //层次遍历
    public int maxLevelSum(TreeNode root) {
        int ans = 0;
        int max = root.val;
        int level = 1;
        LinkedList<TreeNode> list_1 = new LinkedList<>();
        list_1.add(root);
        int count = list_1.size();
        int temp ;
        while (count>0){
            temp = 0;
            while (count>0){
                TreeNode treeNode = list_1.pollFirst();
                temp += treeNode.val;
                if (treeNode.left!=null)
                    list_1.add(treeNode.left);
                if (treeNode.right!=null)
                    list_1.add(treeNode.right);
                --count;
            }
            if (temp>max){
                max = temp;
                ans = level;
            }
            level++;
            count = list_1.size();
        }
        return ans;
    }
}
