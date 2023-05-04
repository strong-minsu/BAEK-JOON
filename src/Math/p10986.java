package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나머지 합
public class p10986 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int []A = new int[N];
        long []S = new long[N];
        long []C = new long[M];

        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1]+A[i];
        }
        for (int i = 0; i < N; i++) {
            int remainder = (int)(S[i]%M);
            //0~i까지의 구간 합 자체가 0인 경우...
            if(remainder == 0){
                answer++;
            }
            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if(C[i]>1){ //나머지가 같은 수가 있을 경우에만 진행
                answer = answer + ((C[i]*(C[i]-1)) / 2);
            }
        }

        System.out.print(answer);
    }
}
