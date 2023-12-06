package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class p11722 {
    static int [] array;
    static int [] dp;
    public static void main(String[] args)throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        //{10, 30, 10, 20, 20, 10}
        array = new int[N];
        for (int i = N-1; i >= 0 ; i--) {
            array[i]= Integer.parseInt(st.nextToken());
        }
        //{10, 20, 20, 10, 30, 10} << 이런식으로 저장 되었겠져..? 여기서 증가 하는 수열의 길이가 가장 긴 것을 구하면 된다~.

        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1; //자기 자신 포함 dp[0] = 1, dp[1] = 1
            //i 까지 증가하는 수열의 길이 저장
            for (int j = 0; j < i; j++) {
                //dp[i] < dp[j]+1  -> 조건에 넣는 이유: 이전에 더 긴 증가 하는 수열이 있었을 수 있음...
                //4, 5, 6, / 3, 4, 5, 6
                //3=1, 4=2, 5=3, 4(1, dp[0]+1=2/dp[3]=2), 6=4(dp[2]+1=4)/4=4(3, 6)
                //5, 4, 3, 6:4
                //20>10
                if(array[i] > array[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        Arrays.sort(dp);
        System.out.print(dp[N-1]);
    }
}
