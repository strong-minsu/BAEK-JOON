package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//피보나치 함수
public class p1003 {
    static long zero, one, zero_one;
    static void dp(int n){
        //초기 값 f(0)
        zero = 1;
        one = 0;
        zero_one=1;
        //f(1)부터 n까지
        for (int i=1; i<=n; i++){
            zero = one;
            one = zero_one;
            zero_one = zero+one;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            dp(n);
            sb.append(zero).append(" ").append(one).append("\n");
        }
        System.out.print(sb);
    }
}
