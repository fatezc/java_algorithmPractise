package practise;
/*
* 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null ||head.next == null||head.next.next==null)
            return;
        //先通过快慢指针将链表分为两部分
        ListNode slow = head,fast = head.next;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head.next;
        //然后将后半部分逆转
        fast = reverseList(fast);
        //然后将前后两部分每次各取一个合并
        ListNode help = head;
        while (fast != null){
            help.next = fast;
            fast = fast.next;
            help = help.next;
            help.next = slow;
            if(slow!=null)
                slow = slow.next;
            help = help.next;
        }
    }
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode pre = head,r;
        head = head.next;
        pre.next = null;
        while (head.next!=null){
            r = head.next;
            head.next = pre;
            pre = head;
            head = r;
        }
        head.next = pre;
        return head;
    }

}
