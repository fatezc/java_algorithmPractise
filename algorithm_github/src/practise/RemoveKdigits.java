package practise;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/*
* 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。

* 输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
* 输入: num = "10", k = 2
输出: "0"
解释: 从原数字移除所有的数字，剩余为空就是0。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-k-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        /*
        当还能删除某个数时，确保栈中单调递增即可
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && stack.peek()>ch && k>0){
                stack.pop();
                --k;
            }
            if (stack.isEmpty() && ch == '0')
                continue;
            stack.push(ch);
        }
        //比如num = “123”的情况
       while (!stack.isEmpty() && k>0){
           stack.pop();
           --k;
       }
       StringBuilder stringBuilder = new StringBuilder();
       while (!stack.isEmpty()){
           stringBuilder.append(stack.pop());
       }
       //针对num = "10",k = 1的情况
       if (stringBuilder.length() >0)
       return stringBuilder.reverse().toString();
       return "0";
    }
}
