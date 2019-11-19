package practise;


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
