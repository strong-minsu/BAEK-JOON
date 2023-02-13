package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class p1181 {
    static int N;
    static String[] words;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }

        //Arrays.sort를 이용함
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                //단어 길이가 같을 경우
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }
                else{
                    return s1.length()-s2.length();
                }
            }
        });
        sb.append(words[0]).append("\n");
        for(int i=1; i<N; i++){
            if (!words[i].equals(words[i-1])){
                sb.append(words[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
