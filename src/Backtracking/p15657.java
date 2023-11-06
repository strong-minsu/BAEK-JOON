package Backtracking;

import java.io.*;
import java.util.*;

public class p15657 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visit;
    static int[] arr;
    static int[] number;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        number = new int[n];

        arr = new int[m];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);

        dfs(0, 0);
        System.out.print(sb);
    }
    private static void dfs(int start, int depth){
        if(depth == m){
            for(int val: arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            arr[depth] = number[i];
            dfs(i, depth+1);
        }
    }
}
