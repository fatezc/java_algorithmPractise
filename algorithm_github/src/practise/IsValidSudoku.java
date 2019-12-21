package practise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set_1 = new HashSet<>();
        Set<Character> set_2 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set_1.clear();
            set_2.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!= '.' && set_1.contains(board[i][j]))
                    return false;
                if (board[j][i]!='.' && set_2.contains(board[j][i]))
                    return false;
                set_1.add(board[i][j]);
                set_2.add(board[j][i]);
            }
        }
        int x,y;
        //x,y代表9块区域中每块区域的左上角坐标
        for (int i = 0; i < 9; i++) {
            x = (i%3)*3;
            y = (i/3)*3;
            set_1.clear();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[x+j][y+k] !='.' && set_1.contains(board[x+j][y+k]))
                        return false;
                    set_1.add(board[x+j][y+k]);
                }
            }
        }
        return true;
    }

}
