package Math;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//조합
public class p2407 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        //BigInteger => 숫자의 범위가 long보다 큼
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            numerator = numerator.multiply(new BigInteger(String.valueOf(n-i)));
            denominator = denominator.multiply(new BigInteger(String.valueOf(i+1)));
        }


        BigInteger answer = numerator.divide(denominator);
        System.out.print(answer);
    }
}
