package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//기찍 N
public class p2742 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = N; i > 0; i--) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
