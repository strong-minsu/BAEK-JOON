package Backtracking;

import java.io.*;
import java.util.*;

public class p15654 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;

    static boolean[] visit;
    static int[] arr;
    static int[] input;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        arr = new int[m];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth){
        if(m == depth){
            for (int value :arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = input[i];
                dfs(depth+1);

                visit[i] = false;
            }

        }
    }
}
