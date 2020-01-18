package practise;
/*
* 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 深拷贝。 

我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CopyRandomList {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    /*
    先将链表1->2做成1->1->2->2的样子,然后复制随机指针,然后拆分
     */
    public Node copyRandomList(Node head) {
        Node p = head;
        while (p!=null){
            Node q = new Node(p.val,p.next,null);
            p.next = q;
            p = q.next;
        }
        p = head;
        while (p!=null){
            p.next.random  = p.random.next;
            p = p.next.next;
        }
        Node ans = head.next;
        Node q = ans;
        p = head;
        while (p!=null){
           p.next = q.next;
           p = p.next;
           if (q.next!=null)
                q.next = p.next;
           q = q.next;
        }
        return ans;
    }
}
