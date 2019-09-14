package practise;
/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ListToBST {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
        {
            TreeNode treehelp = new TreeNode(head.val);
            treehelp.left = null;
            treehelp.right = null;
            return treehelp;
        }
        //找到中间节点的前一个节点,用slow标记
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null){
            fast = fast.next;
            if (fast != null){
                fast =fast.next;
                slow = slow.next;
            }
        }
        TreeNode ans = new TreeNode(slow.next.val);
        ans.right = sortedListToBST(slow.next.next);
        //从中间节点处断开
        slow.next = null;
        ans.left = sortedListToBST(head);
        return ans;
    }
}
