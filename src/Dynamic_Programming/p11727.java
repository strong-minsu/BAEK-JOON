package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//2xn 타일링 2
public class p11727 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long dp[] = new long[1001];

        dp[0] = 1;
        dp[1] = 1;

        int number = Integer.parseInt(br.readLine());
        for (int i = 2; i < number+1; i++) {
            if(i%2==0){
                dp[i] = (dp[i-1]*2+1)%10007;
            }
            else{
                dp[i] = (dp[i-1]*2-1)%10007;
            }
        }

        System.out.print(dp[number]);
    }
}
