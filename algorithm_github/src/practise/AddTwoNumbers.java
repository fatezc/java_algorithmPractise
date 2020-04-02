package practise;
/*
* 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。
你不能对列表中的节点进行翻转。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int len1 = 0,len2 =0;
        ListNode help = l1;
        while (help != null){
            len1++;
            help = help.next;
        }
        help = l2;
        while (help != null){
            len2++;
            help = help.next;
        }
        int[] arr = new int[Math.max(len1,len2)+1];
        int cur = 1;
        while (len1>len2){
            arr[cur++] = l1.val;
            l1 = l1.next;
            len1--;
        }
        while (len1<len2){
            arr[cur++] = l2.val;
            l2 = l2.next;
            len2--;
        }
        while (l1!=null&&l2!=null){
            arr[cur++] = l1.val+l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i]>9){
                arr[i-1] = arr[i]/10;
                arr[i] = arr[i]%10;
            }
        }
        ListNode ans = new ListNode(arr[1]);
        help = ans;
        for (int i = 2; i <arr.length ; i++) {
            help.next = new ListNode(arr[i]);
            help = help.next;
        }
        if (arr[0]>0){
            ListNode head = new ListNode(arr[0]);
            head.next = ans;
            return head;
        }
        return ans;
    }
}