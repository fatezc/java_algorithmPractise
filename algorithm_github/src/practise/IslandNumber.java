package practise;
/*
* 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IslandNumber {
    public int numIslands(char[][] grid) {
        if (grid == null||grid.length==0)
            return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    ans += 1;
                    dfs(grid,i,j);

                }
            }
        }
        return ans ;
    }
    public void dfs(char[][] grid,int i ,int j){
        if (i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1')
            return;
        grid[i][j] = '2';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }

}
