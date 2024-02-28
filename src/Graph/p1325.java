package Graph;

import java.util.*;
import java.io.*;

//효율적인 해킹
//자바로 푸니까 진짜 안풀린다 짜증나

public class p1325 {
    static int n,m;
    static ArrayList<Integer>[] graph;
    static int[] count;
    static boolean [] visited;

    static void dfs (int start){
        Stack<Integer> stack = new Stack<>();

        visited[start] = true;
        stack.add(start);

        while (!stack.isEmpty()){
            int cur = stack.pop();

            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);

                if (!visited[next]){
                    visited[next] = true;
                    count[next]++;
                    stack.add(next);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i]= new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;

            //a -> b를 신뢰한다 -> b 해킹 시 a 해킹 가능 -> b에 a연결.. 근데 이렇게 하면 시간초과
            //a는 b로 인해 해킹 당할 수 있음 으로 생각함 -> a에 b를 연결하고 b의 카운트를 올린다.
            graph[a].add(b);
        }

        int max = Integer.MIN_VALUE;
        count = new int[n];

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i);
        }

        for (int i = 0; i < n; i++) {
            if(max < count[i]) max = count[i];
        }

        for (int i = 0; i < n; i++) {
            if(max == count[i]){
                bw.write((i+1)+" ");
            }
        }

        bw.flush();
        bw.close();

    }
}
