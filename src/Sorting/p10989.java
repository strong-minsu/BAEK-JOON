package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//수 정렬하기 3
public class p10989 {
    static int N;
    static int[] number;
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        for(int i=0; i<N; i++){
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number);
        for(int i=0; i<N; i++){
            sb.append(number[i]).append("\n");
        }
        System.out.print(sb);
    }
}
