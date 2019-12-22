package practise;

import java.util.Stack;

/*
* 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。

每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。

返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NextLargerNodes {
    /*
    单调栈
     */
    public int[] nextLargerNodes(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p!=null) {
            ++count;
            p = p.next;
        }
        int[] ans = new int[count];
        int[] help = new int[count];
        Stack<Integer> stack = new Stack<>();
        p = head;
        for (int i = 0; i < help.length; i++) {
            help[i] = p.val;
            p = p.next;
        }
        for (int i = 0; i < help.length; i++) {
            if (stack.isEmpty() || help[stack.peek()]>=help[i])
                stack.push(i);
            else {
                ans[stack.pop()] = help[i];
                --i;
            }
        }
        while (!stack.isEmpty()){
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}
