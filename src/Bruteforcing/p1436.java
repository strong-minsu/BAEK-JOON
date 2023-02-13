package Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1436 {
    static int N;
    static String M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count = 0;
        int n=0;
        String temp = new String(" ");

        while (true){
            count ++;   //출력할 수 0부터 증가
            temp = Integer.toString(count);
            if(temp.contains("666")){ //666이 포함 된 경우만 검사
                n++;
                if(n==N){
                    System.out.print(count);
                    break;
                }
            }
        }

    }
}
