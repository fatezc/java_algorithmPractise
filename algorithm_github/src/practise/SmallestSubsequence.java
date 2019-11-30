package practise;

import java.util.HashMap;
import java.util.Stack;

/*
* 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
* */
public class SmallestSubsequence {
    /*
    用一个栈保存结果，循环遍历字符串，
1、如果字母已经存在栈中，则跳过；
2、如果字母比栈顶的元素小，且栈顶元素在后面还有，则弹出栈顶。
3、将字母压栈。
     */
    public String smallestSubsequence(String text) {
        int[] help = new int[26];
        //help用来存储各字母最后出现的位置
        for (int i = 0; i < text.length(); i++) {
            help[text.charAt(i)-'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            if (!stack.contains(text.charAt(i))){
                while (!stack.isEmpty() && text.charAt(i)<stack.peek() && help[stack.peek()-'a']>i){
                    stack.pop();
                }
                stack.push(text.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty())
            ans.append(stack.pop());
        return new String(ans.reverse());
    }
}
