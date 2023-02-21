package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이항 계수 1
public class p11050 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int mN=1;
        int mK=1;

        // n!/K!(n-k)!
        for(int i=N; i>K; i--){
            mN *= i;
        }
        for(int i=1; i<=N-K; i++){
            mK *= i;
        }
        int result = mN/mK;

        System.out.print(result);
    }
}
