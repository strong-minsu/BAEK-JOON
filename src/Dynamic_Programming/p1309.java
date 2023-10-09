package Dynamic_Programming;

import java.util.*;
import java.io.*;

//동물원

public class p1309 {
    static int[]dp = new int[100001];

    static void dpFunction(int N){
        for (int i = 3; i <= N; i++) {
            dp[i] = (2*dp[i-1] + dp[i-2])%9901;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp[1] = 3;
        dp[2] = 7;

        dpFunction(N);
        String result = Integer.toString(dp[N]);
        bw.write(result);
        bw.flush();
        bw.close();
    }
}
