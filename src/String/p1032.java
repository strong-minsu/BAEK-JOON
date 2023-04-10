package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//명령 프롬프트
public class p1032 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String [] S = new String[N];
        for (int i = 0; i < N; i++) {
           S[i] = br.readLine();
        }

        int length = S[0].length();
        String pattern = "";
        for (int i = 0; i < length; i++) {
            char c0 = S[0].charAt(i);
            boolean b = true;
            for (int j = 1; j < N; j++) {
                if(c0 != S[j].charAt(i)){
                    b = false;
                    break;
                }
            }
            if(b){
                pattern += Character.toString(c0);
            }
            else {
                pattern += "?";
            }
        }
        System.out.print(pattern);
    }
}
