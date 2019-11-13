package practise;
/*
* 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

返回一个符合上述规则的链表的列表。

举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode help = root;
        int listlength = 0;
        while (help!=null){
            help = help.next;
            listlength++;
        }
        int div = listlength/k;
        int count = listlength%k;
        help = root;
        for (int i = 0; i < ans.length; i++) {
            ListNode list = help;
            int num = div;
            num += count>0?1:0;//num表示ans[i]应该有几个节点
            count--;
            while (num>1&&help!=null){
                help = help.next;
                num--;
            }
            if (help!=null){
                ListNode temp = help.next;
                help.next = null;
                help = temp;
            }
            ans[i] = list;
        }
        return ans;
    }
}
