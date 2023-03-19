package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//상수
public class p2908 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int A;
        int B;

        StringBuilder sb = new StringBuilder();
        for (int i = a.length()-1; i >-1 ; i--) {
            sb.append(a.charAt(i));
        }
        A = Integer.parseInt(sb.toString());

        sb = new StringBuilder();
        for (int i = b.length()-1; i >-1 ; i--) {
            sb.append(b.charAt(i));
        }
        B = Integer.parseInt(sb.toString());

        System.out.print(Math.max(A, B));
    }
}
