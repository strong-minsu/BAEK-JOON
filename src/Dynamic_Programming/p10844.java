package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class p10844 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long mod = 1000000000;

        long [][] dp = new long[N+1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < N+1; i++) {

            for (int j = 0; j < 10; j++) {

                //j가 0인 경우 이전 자리수가 1인 경우
                if(j == 0){
                    dp[i][0] = dp[i-1][1] % mod;
                }
                //j가 9인 경우 이전 자리수가 8인 경우
                else if(j == 9){
                    dp[i][9] = dp[i-1][8] % mod;
                }

                else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])% mod;
                }
            }

        }
        long result = 0;

        // 각 자릿값마다의 경우의 수를 모두 더해준다.
        for(int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.print(result % mod);
    }
}
