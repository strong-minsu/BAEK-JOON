package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//단어 공부
public class p1157 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();

        int[] alpha = new int[26];
        for (int i=0; i<str.length(); i++){
            alpha[str.charAt(i) - 'A']++;
        }

        int max = Integer.MIN_VALUE;
        char c = '?';

        for (int i = 0; i < 26; i++) {
            if(alpha[i]>max){
                max = alpha[i];
                c = (char)(i+65); //대문자 출력이므로
            }
            else if(max == alpha[i]){
                c = '?';
            }
        }
        System.out.print(c);
    }
}
