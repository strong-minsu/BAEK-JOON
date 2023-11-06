package Backtracking;

import java.io.*;
import java.util.*;
//N과 M 9번인가..>?
public class p15663 {
    static int n, m;
    static boolean[] visit;
    static int[] arr;
    static int[] number;

    //LinkedHashSet 입력순으로 정렬됨
    static LinkedHashSet<String> answer;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        number = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);

        arr = new int[m];

        visit = new boolean[n];

        answer = new LinkedHashSet<>();
        dfs(0);
        answer.forEach(System.out::println);
    }

    private static void dfs(int depth) {
        //깊이가 같은 경우
        if(depth == m){
            StringBuilder sb = new StringBuilder();
            for(int val: arr){
                sb.append(val).append(" ");
            }
            answer.add(sb.toString());
            return;
        }
        else{
            for (int i = 0; i < n; i++) {
                if(!visit[i]){
                    visit[i] = true;
                    arr[depth] = number[i];
                    dfs(depth+1);

                    visit[i] = false;
                }
            }
        }
    }
}
