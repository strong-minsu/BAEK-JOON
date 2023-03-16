package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//1, 2, 3 더하기
public class p9095 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long n[] = new long[12];

        n[0] = 1;
        n[1] = 1;
        n[2] = 2;
        for (int i = 3; i < 12; i++) {
            n[i] = n[i-1]+ n[i-2]+ n[i-3];
        }

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            sb.append(n[number]).append("\n");
        }

        System.out.print(sb);
    }
}
