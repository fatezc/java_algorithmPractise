package practise;

import java.util.*;

/*
* 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MergeKLists {
    /*
    逐一比较，时间复杂度（N*K），最后一个用例超时
     */
    public ListNode mergeKLists_1(ListNode[] lists) {
        ListNode ans = new ListNode(-1);
        ListNode p = ans;
        Set<Integer> set = new HashSet<>();
        int min_value = Integer.MAX_VALUE;
        int cur = 0;
        while (set.size()<lists.length){
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    set.add(i);
                if (set.contains(i))
                    continue;
                if (min_value>=lists[i].val){
                    min_value = lists[i].val;
                    cur = i;
                }
            }
            if (lists[cur]!=null){
                p.next = lists[cur];
                lists[cur] = lists[cur].next;
            }
            if (p!=null)
            p = p.next;
            min_value = Integer.MAX_VALUE;
            if (lists[cur] == null)
                set.add(cur);
        }
        if (p!=null)
        p.next = null;
        return ans.next;
    }
    /*
    用堆来存储与比较，可降至（N*LogK）,通过
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0);
        ListNode help = ans;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return lists[o1].val-lists[o2].val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null)
                priorityQueue.add(i);
        }
        int temp;
        while (!priorityQueue.isEmpty()){
            Integer poll = priorityQueue.poll();
            help.next = lists[poll];
            help = help.next;
            lists[poll] = lists[poll].next;
            if (lists[poll]!=null)
                priorityQueue.add(poll);
        }
        help.next = null;
        return ans.next;
    }
}
