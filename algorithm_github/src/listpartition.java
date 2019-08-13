
public class listpartition {
    public  class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
    }

    /*
    * 把一个单链表调整为小于pivot,等于pivot,大于pivot的顺序,并保持稳定性
    * 方法:创建三个链表,在遍历过程中分别按顺序保存小于pivot,等于pivot,大于pivot的部分,最后再拼接起来
    *       注意每个链表保存第一个元素和为空的情况;
    * */
    public static Node listPartition(Node head,int pivot){
        Node sh = null;//小的头
        Node st = null;//小的尾
        Node eh = null;//相等的头
        Node et = null;//相等的尾
        Node bh = null;//大的头
        Node bt = null;//大的尾
        Node next = null; //保存下一个节点

        //所有节点分进三个列表
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value<pivot){
                if (sh == null){
                    sh = head;
                    st = head;
                } else {
                    st.next = head;
                    st = head;
                }
            }
            else if (head.value == pivot){
                if (eh == null){
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
            }
            else {
                if (bh == null){
                    bh = head;
                    bt = head;
                } else {
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }
        if (st != null){
            st.next = eh;
            et = et==null?st:et;
        }
        if (et != null){
            et.next = bh;
        }
        return sh != null?sh:eh!=null?eh:bh;
    }
}
