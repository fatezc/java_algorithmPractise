package practise;
/*
* 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。

找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/smallest-string-starting-from-leaf
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SmallestFromLeaf {
    String ans;
    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return "";
        ans = String.valueOf((char)('a'+26));
        dfs(root,new StringBuilder());
        return ans;
    }
    public void dfs(TreeNode root,StringBuilder sb){
        if (root == null)
            return;
        sb.append((char)('a'+root.val));
        if (root.left == null&&root.right == null){
            sb.reverse();
            String s = sb.toString();
            sb.reverse();
            if (ans.compareTo(s)>0)
                ans = s;
        }

        dfs(root.left,sb);
        dfs(root.right,sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
