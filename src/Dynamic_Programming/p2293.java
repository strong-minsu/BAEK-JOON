package Dynamic_Programming;

import java.io.*;
import java.util.*;

// 동전 1
public class p2293 {
    static int n, k;
    static int[]  dp;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        //1~10
        dp = new int[k+1];
        dp[0]= 1;

        // dp 배열 인덱스.. 만큼의 가치를 만들 수 있는 경우의 수를 저장한다.
        // dp[i] = j -> 일 때 i를 만들 수 있는 경우의 수 j
        // dp[i] = dp[i] + dp[i - 가진 동전 가치];

        int coin = 0;
        for(int i = 1 ; i <= n; i++) {
            coin = Integer.parseInt((br.readLine()));

            for (int j = coin; j <= k; j++)
                dp[j] = dp[j] + dp[j - coin];

            //1로 j를 만들 수 있는 경우의 수
            // 1 2 3 4 5 6 7 8 9 10
            // 1 1 1 1 1 1 1 1 1  1

            //2로 j를 만들 수 있는 경우의 수
            //   2 3 4 5 6 7 8 9 10
            //   2 2 3 3 4 4 5 5  6

            //5로 j를 만들 수 있는 경우의 수
            //         5 6 7 8 9 10
            //         4 5 6 7 8 10
        }

        bw.write(dp[k]+"");
        bw.flush();
        bw.close();
    }

}
