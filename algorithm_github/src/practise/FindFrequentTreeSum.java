package practise;

import java.util.HashMap;
import java.util.Set;

/*
* 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class FindFrequentTreeSum {
    private HashMap<Integer,Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[]{};
        map = new HashMap<>();
        treeAdd(root);
        Object[] objects = map.values().toArray();
        int maxValue = 0,count = 0;
        for (Object object : objects) {
            if ((int)object>maxValue){
                maxValue = (int)object;
                count=1;
            }else if ((int)object == maxValue)
                ++count;
        }
        int[] ans = new int[count];
        int i = 0;
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            if (map.get(integer) == maxValue)
                ans[i++] = integer;
        }
        return ans;
    }
    public int treeAdd(TreeNode root){
        if (root == null)
            return 0;
        int left = treeAdd(root.left);
        int right = treeAdd(root.right);
        map.put(left+right+root.val,map.getOrDefault(left+right+root.val,0)+1);
        return left+right+root.val;
    }
}
