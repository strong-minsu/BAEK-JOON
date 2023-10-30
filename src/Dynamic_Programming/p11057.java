package Dynamic_Programming;

import  java.io.*;
import  java.util.*;

//오르막 수
public class p11057 {
    static int N;
    static long[][] dp;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 점화식 : dp[i][자리수] += dp[i-1][0~현재 자리수];
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k] % 10007;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.print(result%10007);
    }
}
