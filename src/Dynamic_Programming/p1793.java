package Dynamic_Programming;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

//타일링

public class p1793 {
    static BigInteger [] dp = new BigInteger[251];

    static void dpFunction(int n){
        for (int i = 3; i <= n; i++) {
            BigInteger result = dp[i-1].multiply(BigInteger.valueOf(2));
            if(i%2 == 0){
                result = result.add(BigInteger.valueOf(1));
            }
            else{
                result = result.subtract(BigInteger.valueOf(1));
            }
            dp[i] = result;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String st = br.readLine();

        Arrays.fill(dp, BigInteger.valueOf(-1));

        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(3);

        //while (st != null){ 백준 제출시.!
        while (!st.equals("")){
            int n = Integer.parseInt(st);
            if(dp[n].compareTo(BigInteger.valueOf(-1)) == 0){
                    dpFunction(n);
            }
            sb.append(dp[n]).append("\n");
            st = br.readLine();
        }

        System.out.print(sb);
    }
}
