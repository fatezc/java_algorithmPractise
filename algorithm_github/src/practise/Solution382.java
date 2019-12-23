package practise;

public class Solution382 {
    private ListNode head;
    public Solution382(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int ans = head.val;
        ListNode p = head;
        long help = 1;
        while (p.next!=null){
            p = p.next;
            help++;
            if (Math.random() <=1.0/help )
                ans = p.val;
        }
        return ans;
    }
}
