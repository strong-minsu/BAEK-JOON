package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문자열 반복
public class p2675 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(str.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
