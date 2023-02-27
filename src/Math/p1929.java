package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//소수 구하기
public class p1929 {
    static boolean number[];
    static int M, N;
    //에라토스테네스의 체 이용
    static void E (int n){
        //n을 제외한 배수를 지운다.
        int length = N/n;
        for(int i=2; i<=length; i++){
            number[n*i]= true;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        number = new boolean[N+1];//false로 초기화됨
        number[0] = true;
        number[1] = true;

        for(int i=2; i<=N; i++){
            if(!number[i]){
                E(i);
            }
        }
        for(int i=M; i<=N; i++){
            if(!number[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
