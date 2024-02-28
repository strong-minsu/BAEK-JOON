package Graph;

import java.util.*;
import java.io.*;

//줄 세우기
public class p2252 {
    static int n, m;
    static LinkedList<Integer>[] Graph;
    static int[] array, result;
    static void addEdge(int a, int b){
        Graph[a].add(b);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Graph = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            Graph[i] = new LinkedList<>();
        }

        array = new int[n+1];
        result = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            addEdge(v1, v2);
            array[v2]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n+1; i++) {
            if(array[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int student = queue.poll();

            sb.append(student+ " ");


            for (int i = 0; i < Graph[student].size(); i++) {
                int next = Graph[student].get(i);
                array[next]--;
                if (array[next] == 0){
                    queue.add(next);
                }
            }
        }

        System.out.print(sb);

    }
}
