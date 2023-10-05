package Dynamic_Programming;

import java.util.*;
import java.io.*;

//01타일

public class p1904 {
    static int N;
    static int[] dp = new int[1000001];

    static void dpFunction(int N){
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dpFunction(N);

        System.out.print(dp[N]);
    }
}
