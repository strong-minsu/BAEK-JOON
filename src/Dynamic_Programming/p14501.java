package Dynamic_Programming;


import java.io.*;
import java.util.*;

public class p14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n+1];
        int[] p = new int[n+1];

        StringTokenizer st;
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        //dp : N일에 얻을 수 있는 최대 수익
        int[] dp = new int[n+1];

        //점화식
        //현재 날짜에서 소요 시간과 비용을 더해 dp에 저장한다.
        //이후, 중복될 때 최대값을 넣는다.
        //dp[i + t[i] -1] = Math.max(dp[i + t[i]-1], dp[i-1] + p[i]);

        for (int i=1; i<=n; i++) {
            if (i + t[i] <= n+1) {
                //날짜가 범위를 넘어가지 않는 경우
                dp[i + t[i] -1] = Math.max(dp[i + t[i]-1], dp[i-1] + p[i]);
            }
            // 현재 dp배열에 0이 들어올 수도 잇기 때문,, 해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 한다.
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        System.out.println(dp[n]);

    }
}
