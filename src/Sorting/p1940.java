package Sorting;

import java.util.*;
import java.io.*;

//주몽

public class p1940 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int count = 0;

        int i = 0;
        int j = N-1;

        while (i<j){
            if(array[i]+array[j] > M){
                j--;
            }
            else if(array[i]+array[j] < M){
                i++;
            }
            else{
                i++;
                j--;
                count++;
            }
        }

        System.out.print(count);
    }
}
