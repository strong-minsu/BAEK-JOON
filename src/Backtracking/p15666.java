package Backtracking;

import java.util.*;
import java.io.*;

public class p15666 {
    static int n, m;
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

        answer = new LinkedHashSet<>();
        dfs(0, 0);
        answer.forEach(System.out::println);
    }

    private static void dfs(int depth, int start) {
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
            for (int i = start; i < n; i++) {
                arr[depth] = number[i];
                dfs(depth+1, i);
            }
        }
    }
}
