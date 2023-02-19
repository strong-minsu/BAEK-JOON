package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최대공약수와 최소공배수
//유클리드 호제법을 이용하여 구현
public class p2609 {
    static int GCD (int a, int b){
        int result;
        if(b==0){
            result=a;
            return result;
        }
        else{
            return GCD(b, a%b);
        }
    }
    static long LCM (int a, int b){
        long result;
        result = (a * b) / GCD(a, b);
        return result;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int number1 = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());

        int big = Math.max(number1, number2);
        int small = Math.min(number1, number2);

        sb.append(GCD(big, small)).append("\n").append(LCM(big, small));
        System.out.print(sb);
    }
}
