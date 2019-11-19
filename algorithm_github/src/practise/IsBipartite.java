package practise;

/*
* 给定一个无向图graph，当这个图为二分图时返回true。

如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。

graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-graph-bipartite
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IsBipartite {
    private int[] help;
    public boolean isBipartite(int[][] graph) {
        help = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            //dfs每个节点，对于每个节点，如果还未染色，则先染成1（-1也行，不影响）
            if (help[i] == 0)
                help[i] = 1;
            if (!dfs(i,graph))
                return false;
        }
        return true;
    }
    /*
    递归给每层染不同的颜色（置为1或-1），同时判断是否存在颜色冲突：help[i]*help[j] == 1，有则返回false
     */
    public boolean dfs(int cur,int[][] graph){
        for (int i = 0; i <graph[cur].length  ; i++) {
            if (help[graph[cur][i]]*help[cur] == 1)
                return false;
            if (help[graph[cur][i]]*help[cur] == -1)
                continue;
            help[graph[cur][i]] = -help[cur];
            dfs(graph[cur][i],graph);
        }
        return true;
    }
}
