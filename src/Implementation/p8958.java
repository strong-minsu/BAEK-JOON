package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//OX퀴즈
public class p8958 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int count = 0;
            int sum = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'O'){
                    count++;
                    sum += count;
                }
                else {
                    count = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
