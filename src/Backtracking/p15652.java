package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15652 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(0, 1);

        System.out.print(sb);
    }
    private static void dfs(int depth, int start) {
        if(depth == m){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        //방문 체크X (중복도 가능)
        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(depth+1, i);
        }
    }
}
