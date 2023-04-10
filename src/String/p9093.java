package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//단어 뒤집기
public class p9093 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            for (int j = 0; j < size; j++) {
                String s = st.nextToken();
                String newS = "";
                for (int k = s.length()-1; k >= 0; k--) {
                    newS += Character.toString(s.charAt(k));
                }
                sb.append(newS).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
