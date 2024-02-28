package Dynamic_Programming;

import java.util.*;
import java.io.*;

//동전
public class p9084 {
    static int T;
    public static void main(String[] args)throws Exception{
        //동전의 종류가 주어질 때 주어진 금액을 만드는 방법을 세는 프로그램~

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(br.readLine());
            int [] dp = new int[m+1];
            dp[0] = 1;

            for (int j = 0; j < n; j++) {
                int coin = Integer.parseInt(st.nextToken());
                for (int k = coin; k < m+1; k++) {
                    dp[k] = dp[k] + dp[k-coin];
                }
            }

            bw.write(dp[m]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
