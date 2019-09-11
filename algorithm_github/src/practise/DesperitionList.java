package practise;
/*
* 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。
* */
public class DesperitionList {
    public class ListNode {
     int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
  //将原链表分成小于x和不小于x的两个链表,然后考虑三种情况返回
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
            ListNode sh = null;
            ListNode st = null;
            ListNode bh = null;
            ListNode bt = null;
            while (head != null){
                if (head.val<x){
                    if (sh == null)
                        {sh = head;
                        st = head;
                        }
                    else {
                        st.next = head;
                        st = st.next;
                    }
                }
                else {
                    if (bh == null){
                        bh = head;
                        bt = head;
                    }
                    else {
                        bt.next = head;
                        bt = bt.next;
                    }
                }
                head = head.next;
            }
            if (sh == null){
                bt.next = null;
                return bh;
            }
            if (bh == null){
                st.next = null;
                return sh;
            }
            st.next = bh;
            bt.next = null;
            return sh;
    }
}

