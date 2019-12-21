package practise;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int flag = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    dfs(grid,i,j,flag);
                flag++;
            }
        }
        int[] help = new int[flag+1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]>=2)
                    help[grid[i][j]]++;
            }
        }
        int ans = 0;
        for (int i = 2; i < help.length; i++) {
            ans = Math.max(ans,help[i]);
        }
        return ans;
    }
    public void dfs(int[][] grid,int x,int y,int flag){
        if (x<0||y<0||x>=grid.length||y>=grid[0].length || grid[x][y] != 1)
            return ;
        grid[x][y] = flag;
        dfs(grid,x+1,y,flag);
        dfs(grid,x-1,y,flag);
        dfs(grid,x,y+1,flag);
        dfs(grid,x,y-1,flag);
    }
}
