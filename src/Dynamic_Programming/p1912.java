package Dynamic_Programming;

import java.util.*;
import java.io.*;

//연속합
public class p1912 {
    static int n;
    static int[] dp;
    static int[] number;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        number = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = Integer.MIN_VALUE;
        dp[1] = number[1];

        for (int i = 2; i < n+1; i++) {
            dp[i] = Math.max(dp[i-1]+number[i], number[i]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            if(result < dp[i]){
                result = dp[i];
            }
        }
        System.out.print(result);
    }
}
