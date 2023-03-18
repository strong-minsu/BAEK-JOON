package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//2xn 타일링
public class p11726 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long dp[] = new long[1001];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
                dp[i] = (dp[i-1]+dp[i-2])%10007;
        }

        System.out.print(dp[Integer.parseInt(br.readLine())]);
    }
}
