package practise;

import java.util.LinkedList;
import java.util.List;

/*
* 给定一个二叉树，在树的最后一行找到最左边的值。
 * */
public class FindBottomLeftValue {
    //采用层次遍历,每到下一层记录第一个节点的值
    public int findBottomLeftValue(TreeNode root) {
        int ans = root.val;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int count = 1;//count记录每一层的节点个数

        while (count>0){
            if (count>0){
                TreeNode cur = list.poll();
                --count;
                if (cur.left!=null){
                    list.add(cur.left);
                }if (cur.right!=null){
                    list.add(cur.right);
                }
            }
            if (count == 0){
               if (!list.isEmpty()){
                   ans = list.peek().val;
                   count = list.size();
               }
            }
        }
        return ans;
    }
}
