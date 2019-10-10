package practise;
/*
* n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
* */
public class TotalNQueens {
    private int ans;
    public int totalNQueens(int n) {
        if (n<=0)
            return 0;
        int[] location= new int[n];
      ans = 0;
        NQueens(location,0);
        return ans;
    }
    public void NQueens(int[] location,int cur){
        if (cur == location.length){
            ans++;
            return;
        }
        for (int i = 0; i < location.length; i++) {
            if (isValid(i,cur,location)){
                location[cur] = i;
                NQueens(location,cur+1);
            }
        }
    }
    public boolean isValid(int i,int cur,int[] location){
        for (int j = 0; j < cur; j++) {
            if (i == location[j]||Math.abs(cur-j)==Math.abs(i-location[j]))
                return false;
        }
        return true;
    }
}
