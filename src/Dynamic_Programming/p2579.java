package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//계단 오르기
public class p2579 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] Stairs = new int[301];
        int [] sum = new int[301];

        for(int i=1; i<=N; i++){
            Stairs[i] = Integer.parseInt(br.readLine());
        }
        sum[1] = Stairs[1];
        sum[2] = Stairs[1] + Stairs[2];
        sum[3] = Math.max(Stairs[1], Stairs[2]) + Stairs[3];

        for (int i=4; i<=N; i++){
            //조건
            //1. 계단은 한 번에 한 계단 또는 두 계단씩 오를 수 있다.
            //2. 연속된 세 개의 계단을 밟아선 안 된다.
            //3. 마지막 계단은 반드시 밟아야 한다.
            // Math.max(3단계 전까지의 점수의 합과 1단계 이전의 계단 점수, 2단계 전까지의 합)
            // 마지막에는 마지막 계단의 점수를 무조건 더한다.
            sum[i] = Math.max(sum[i-3]+Stairs[i-1], sum[i-2]) + Stairs[i];
        }

        System.out.print(sum[N]);
    }
}
