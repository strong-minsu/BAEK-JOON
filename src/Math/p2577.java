package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 숫자의 개수
public class p2577 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int result = A*B*C;
        int count[] = new int[10];

        String str = Integer.toString(result);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int n = c - '0';
            count[n]++;
        }
        for (int i = 0; i < count.length; i++) {
            sb.append(count[i]).append("\n");
        }

        System.out.print(sb);
    }
}
