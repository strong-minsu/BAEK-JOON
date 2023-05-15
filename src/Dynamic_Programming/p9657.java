package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//돌 게임 3
public class p9657 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[1001];
        //상근이가 이기는 경우 1, 창영이가 이기는 경우 0
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        for(int i=5;i<=1000;i++){
            //게임을 완벽하게 함, -> 상근이에게 선택권이 있다.
            //1, 3, 4 중 창영이가 이겼던 경우가 한 번이라도 있으면, 무조건 상근이가 이김
            if(dp[i-1]+dp[i-3]+dp[i-4]<3){
                dp[i]=1;
            }
            else { //1, 3, 4 모두 상근이가 이겼다면, 다음턴은 무조건 창영이가 이김
                dp[i] = 0;
            }
        }
        if(dp[n] == 1){
            System.out.print("SK");
        }
        else{
            System.out.print("CY");
        }
    }
}
