package Dynamic_Programming;

import java.io.*;
import java.util.*;

//포도주 시식

public class p2156 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[10001];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int [] dp = new int[10001];
        dp[0] = 0;
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i],dp[i-3] + wine[i-1] + wine[i]));

        }

        bw.write(dp[n]+"\n");
        bw.flush();
        bw.close();

    }
}
