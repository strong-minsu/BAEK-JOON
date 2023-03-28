package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//잃어버린 괄호
public class p1541 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minus_st = new StringTokenizer(br.readLine(), "-");

        int m = minus_st.countTokens();
        int sum[] = new int[m];
        for (int i = 0; i < m; i++) {
            StringTokenizer plus_st = new StringTokenizer(minus_st.nextToken(), "+");
            int p = plus_st.countTokens();
            for (int j = 0; j < p; j++) {
                int s = Integer.parseInt(plus_st.nextToken());
                sum[i] += s;
            }
        }

        int result = sum[0];
        for (int i = 1; i < sum.length; i++) {
            result -= sum[i];
        }

        System.out.print(result);
    }
}
