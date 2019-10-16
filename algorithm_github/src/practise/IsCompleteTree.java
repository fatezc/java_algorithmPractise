package practise;

import java.util.LinkedList;
import java.util.List;

/*
* 给定一个二叉树，确定它是否是一个完全二叉树。
* */
public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        TreeNode cur;
        boolean flag = true;
        list.add(root);
        while (!list.isEmpty()){
            cur = list.get(0);
            if (!flag&&(cur.left!=null||cur.right!=null))
                return false;
            if (cur.left==null&&cur.right!=null)
                return false;
            if (cur.left!=null&&cur.right!=null){
                list.add(cur.left);
                list.add(cur.right);
            }
            if (cur.left!=null&&cur.right==null){
                flag = false;
                list.add(cur.left);
            }
            if (cur.left == null)
                flag = false;
            list.remove(0);
        }
        return true;
    }
}
