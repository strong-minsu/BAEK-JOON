package Backtracking;

import java.util.*;
import java.io.*;
public class p15650 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visit;
    static int[] arr;
    static int[] number;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = i+1;
        }
        arr = new int[m];

        visit = new boolean[n];
        dfs(0,0);
        System.out.print(sb);
    }

    private static void dfs(int depth, int start) {
        //깊이가 같은 경우
        if(depth == m){
            for(int val: arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for (int i = start; i < n; i++) {
                if(!visit[i]){
                    visit[i] = true;
                    arr[depth] = i+1;
                    dfs(depth+1, i);

                    visit[i] = false;
                }
            }
        }
    }
}
