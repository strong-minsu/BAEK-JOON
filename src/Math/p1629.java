package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//곱셈
public class p1629 {
    static int C;
    //분할정복을 이용한 거듭제곱
    // C**n
    //n이 짝수인 경우 C**n/2 * C**n/2
    //n이 홀수인 경우 C**(n-1)/2 * C**(n-1)/2 * C

    private static long pow(long a, long n) {
        if (n == 1)
            return a % C;
        long tmp = pow(a, n/2);
        if (n%2==0)
            return tmp * tmp % C;
        else
            //tmp*tmp*a -> 이게 long를 넘어갈 수 잇음..
            //따라서 (a * b) % C = (a%C * b%C)%C -> 모듈러 합동 공식 이용
            return (tmp * tmp % C) * a % C;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.print(pow(A, B));
    }
}
