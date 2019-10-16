package practise;
/*
* 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。

学生出勤记录是只包含以下三个字符的字符串：

'A' : Absent，缺勤
'L' : Late，迟到
'P' : Present，到场
如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/student-attendance-record-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CheckRecord {
    public int checkRecord(int n) {
        if (n==1)
            return 3;
        if (n==2)
            return 8;
        int mod = 1000000007;
        long ans = 0;
        long[][][] dp = new long[n+1][2][3];
        //有两个数，且A个数为零，结尾不为L  --PP LP
        dp[2][0][0]=2;
        //有两个数，且A的个数为1，结果不为L  AP 和PA LA
        dp[2][1][0]=3;
        //有两个数，没有A，且结尾为L  --PL
        dp[2][0][1]=1;
        //有两个数，一个A，且结尾为L -- AL
        dp[2][1][1]=1;
        //有两个数，结尾为两个L   ---LL
        dp[2][0][2]=1;
        //有两个数，结尾两个L，有一个A ---无
        dp[2][1][2]=0;
        for (int i = 3; i <n+1 ; i++) {
            dp[i][0][0] = (dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%mod;
            dp[i][1][0] = (dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][1][2]+dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%mod;
            dp[i][0][1] = dp[i-1][0][0]%mod;
            dp[i][1][1] = dp[i-1][1][0]%mod;
            dp[i][0][2] = dp[i-1][0][1];
            dp[i][1][2] = dp[i-1][1][1];
        }
        ans = (dp[n][0][0]+dp[n][1][0]+dp[n][0][1]+dp[n][1][1]+dp[n][0][2]+dp[n][1][2])%mod;
        return (int) ans;
    }
}
