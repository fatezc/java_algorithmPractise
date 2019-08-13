
public class listpartition {
    public  class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
    }
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
