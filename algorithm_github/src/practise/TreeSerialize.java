package practise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeSerialize {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public String serialize(TreeNode root) {

        return treeSerialize(root,new StringBuilder("")).toString();
    }
    public StringBuilder treeSerialize(TreeNode root ,StringBuilder s){
        if (root == null)
        {
            s.append("null,");
            return s;
        }
        s.append(root.val).append(",");
        s= treeSerialize(root.left,s);
        s = treeSerialize(root.right,s);
        return s;
    }
    public TreeNode deserialize(String data) {
        String [] str = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(str));
        return treeDeSerialize(list);
    }
    public TreeNode treeDeSerialize(List<String> list){
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = treeDeSerialize(list);
        root.right = treeDeSerialize(list);
        return root;
    }
}
