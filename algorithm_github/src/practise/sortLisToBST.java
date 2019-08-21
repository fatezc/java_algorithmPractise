package practise;

/*
* 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class sortLisToBST {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //先将链表转成数组,然后递归
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null){
            ++n;
            p = p.next;
        }

        int[] array = new int[n];
        n=0;
        while (head != null){
            array[n++] = head.val;
            head = head.next;
        }
        TreeNode ans = listToBst(array,0,array.length-1);
        return ans;
    }
    public TreeNode listToBst(int[] array , int left, int right){
        if(left<0||right>array.length||left>right)
            return null;
        if (left == right)
            return new TreeNode(array[left]);
        if (left<right){
            TreeNode lefthead = listToBst(array,left,(left+right)/2-1);
            TreeNode righthead = listToBst(array,(left+right)/2+1,right);
            TreeNode mid = new TreeNode(array[(left+right)/2]);
            if (lefthead!=null)
                mid.left = lefthead;
            if (righthead!=null)
                mid.right = righthead;
            return mid;
        }
        return null;
    }
}
