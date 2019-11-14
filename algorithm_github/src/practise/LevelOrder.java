package practise;

import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new LinkedList<>();
            if(root == null)
                return ans;
            LinkedList<Integer> list = new LinkedList<>();
            LinkedList<Node> help = new LinkedList<>();
            list.add(root.val);

            help.add(root);
            int count = 1;
            while(count != 0){
                list.clear();
                while(count != 0){
                    --count;
                    Node node = help.pollFirst();
                    list.add(node.val);
                    while(node.children.size()>0){
                        help.add(node.children.get(0));
                        node.children.remove(0);
                    }
                }
                ans.add(new LinkedList(list));
                count = help.size();
            }
            return ans;
        }
    }
}
