package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 수열
//여렵... ㅠ_ㅠ
public class p11053 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        int dp[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if(dp[i] < dp[j]+1 && A[j] < A[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }

        Arrays.sort(dp);
        System.out.print(dp[N-1]);
    }
}
