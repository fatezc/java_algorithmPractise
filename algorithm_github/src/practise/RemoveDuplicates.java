package practise;

import java.util.Stack;

/*
* 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。

在执行完所有删除操作后，返回最终得到的字符串。

本题答案保证唯一。
* */
public class RemoveDuplicates {
    //用栈实现，将字母和目前的次数封装成Node,也可以用两个栈
    public class Node{
        private char ch;
        private int count;
        Node(char ch,int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (int i = s.length()-1; i>=0 ; i--) {
            if (!stack.isEmpty() && stack.peek().ch == s.charAt(i))
                stack.push(new Node(s.charAt(i),stack.peek().count+1));
            else stack.push(new Node(s.charAt(i),1));
            if (stack.peek().count == k){
                char cha = stack.peek().ch;
                while (!stack.isEmpty() && stack.peek().ch == cha)
                    stack.pop();
            }
        }
        String ans = "";
        while (!stack.isEmpty())
            ans += stack.pop().ch;
        return ans;
    }
}
