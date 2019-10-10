package practise;
/*
* 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/odd-even-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class OddEvenList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        int i = 1;
        ListNode oddfirst = head ,oddlast = head ;
        ListNode evenfirst = head ,evenlast = head ;
        while(head!=null){
            if(i==1){
                oddfirst = head;
                oddlast = head;
            }
            if(i == 2){
                evenfirst = head;
                evenlast = head;
            }
            if(i>2&&i%2 == 1){
                oddlast.next = head;
                oddlast = head;
            }
            if(i>2&&i%2==0){
                evenlast.next = head;
                evenlast = head;
            }
            head = head.next;
            ++i;
        }
        oddlast.next = evenfirst;
        evenlast.next = null;
        return oddfirst;
    }
}
