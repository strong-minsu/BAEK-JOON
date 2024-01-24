package Graph;

import java.util.*;
import java.io.*;

//선수과목(Prerequisite)
public class p14567 {
    static int N, M;
    static int[] array;
    static int[] result;
    static LinkedList<Integer>[] graph;

    static void addEdge(int a, int b){
        graph[a].add(b);
    }

    static void toplogySort(){
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 1; i < N+1; i++) {
            if(array[i] == 0){
                queue.add(new int[]{i, 1});
            }
        }

        while (!queue.isEmpty()){
            int current[] = queue.poll();
            int node = current[0];
            int value = current[1];
            result[node] = value;

            for (int i = 0; i < graph[node].size(); i++) {
                int next = graph[node].get(i);
                array[next] -= 1;
                if(array[next] == 0){
                    queue.add(new int[]{next, value+1});
                }
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new LinkedList<>();
        }

        array = new int[N+1];
        result = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            addEdge(v1, v2);
            array[v2]++;
        }

        toplogySort();

        for (int i = 1; i < N+1; i++) {
            sb.append(result[i]+" ");
        }
        System.out.print(sb);

    }
}
