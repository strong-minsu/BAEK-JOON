package Dynamic_Programming;

import java.util.*;
import java.io.*;

//정수 삼각형

public class p1932 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int [][] Triangle = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                Triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int[501][501];

        for (int i = 1; i <= N; i++) {
            dp[N][i] = Triangle[N][i];
        }

        for (int i = N-1; i >= 1; i--) {
            for (int j = 1; j <= i ; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + Triangle[i][j];
            }
        }

        System.out.print(dp[1][1]);

    }
}
