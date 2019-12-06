package practise;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < len/2; j++) {
                /*
                只有当对应的两个位置相同时才会变
                 */
                if ((A[i][j] ^ A[i][len-1-j]) == 0){
                    A[i][j] = 1-A[i][j];
                    A[i][len-1-j] = A[i][j];
                }
            }
            if (len %2 ==1)
                A[i][len/2] = 1 - A[i][len/2];
        }
        return A;
    }
}
