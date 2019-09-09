package practise;
/*为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。
牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。
牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
每个输入包含一个测试用例。
每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
保证不存在两项工作的报酬相同。
* */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FindWork {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int [] help = new int[2];
            help[0] = in.nextInt();
            help[1] = in.nextInt();
            list.add(help);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int Ai,left,right,mid;
        for (int i = 0; i < M; i++) {
            Ai = in.nextInt();
            left = 0;right = N-1;
            while (left<right){
                mid = (left+right)/2;
                if (list.get(mid)[0] >Ai )
                    right = mid-1;
                else if (list.get(mid)[0]<Ai)
                    left = mid;
                else {
                    while (list.get(mid)[0] == Ai)
                        mid++;
                    left = right =mid-1;
                }
            }
            System.out.println(list.get(right)[1]);
        }
    }
}
