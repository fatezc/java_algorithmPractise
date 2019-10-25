package practise;
/*
* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class addTwoNumbers2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //len1和len2用来统计l1和l2的长度
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

        //如果需要则交换l1和l2,确保l1是较短的那个
        if (len1>len2){
            help = l1;
            l1 = l2;
            l2 = help;
        }


        //得到len1和len2中较大和较小的那个
        int biggerlen = Math.max(len1,len2);
        int smallerlen = len1+len2-biggerlen;

        //用数组将两个链表对应的值加起来
        int[] arr = new int[biggerlen+1];
        for (int i = 0; i < smallerlen; i++) {
            arr[i] += l1.val;
            l1 = l1.next;
        }
        for (int i = 0; i < biggerlen; i++) {
            arr[i] += l2.val;
            l2 = l2.next;
            if (arr[i]>=10){
                arr[i+1]++;
                arr[i] %= 10;
            }
        }

        //生成返回链表
        ListNode ans = new ListNode(arr[0]);
        help = ans;
        for (int i = 1; i < arr.length - 1; i++) {
            help.next = new ListNode(arr[i]);
            help = help.next;
        }
        if (arr[arr.length-1]!= 0)
            help.next = new ListNode(arr[arr.length-1]);
        return ans;
    }

}
