package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//2+1 세일
public class p11508 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = 0;
        int N = Integer.parseInt(br.readLine());
        Integer []C = new Integer[N];

        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(br.readLine());
            answer += C[i];
        }
        Arrays.sort(C, Comparator.reverseOrder());

        int count = N/3;
        int index = 2;
        while(count>0) {
            answer -= C[index];
            index += 3;
            count--;
        }

        System.out.print(answer);
    }
}
