package Graph;

import java.io.*;
import java.util.*;

//특정한 최단 경로
public class p1504 {
    static int N, E, v1, v2;
    static LinkedList<Edge>[] Graph;
    static PriorityQueue<Edge> priorityQueue;
    static boolean [] visited;
    static int[] cost;
    static int INF = 200000000;

    static int dijkstra(int start, int end){
        priorityQueue = new PriorityQueue<>();

        Arrays.fill(cost, INF);
        Arrays.fill(visited, false);

        cost[start] = 0;

        priorityQueue.add(new Edge(start, 0));

        while (!priorityQueue.isEmpty()){
            Edge current = priorityQueue.poll();
            int currentVertex = current.vertex;

            if(visited[currentVertex]) continue;

            visited[currentVertex] = true;
            for (int i = 0; i < Graph[currentVertex].size(); i++) {
                Edge next = Graph[currentVertex].get(i);

                int nextVertex = next.vertex;
                int nextValue = next.value;

                if(cost[nextVertex] > cost[currentVertex]+nextValue){
                    cost[nextVertex] = cost[currentVertex]+nextValue;
                    priorityQueue.add(new Edge(nextVertex, cost[nextVertex]));
                }
            }

        }

        return cost[end];
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Graph= new LinkedList[N+1];
        for (int i = 0; i < N+1; i++) {
            Graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Graph[a].add(new Edge(b, c));
            Graph[b].add(new Edge(a, c));
        }

        visited = new boolean[N+1];
        cost = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int startTov1 = dijkstra(1, v1);
        int startTov2 = dijkstra(1, v2);

        int v1Tov2 = dijkstra(v1, v2);

        int v1Toend = dijkstra(v1, N);
        int v2Toend = dijkstra(v2, N);

        int result1 = startTov1 + v1Tov2 + v2Toend;
        int result2 = startTov2 + v1Tov2 + v1Toend;

        if(result1 >= INF && result2 >= INF){
            System.out.print(-1);
        }
        else{
            System.out.print(Math.min(result1, result2));
        }
    }

    static class Edge implements Comparable<Edge>{
        int vertex, value;
        Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }

        //우선순위 큐 사용을 위한 오버라이딩
        public int compareTo(Edge e){
            if(this.value> e.value){
                return 1;
            }
            return -1;
        }
    }
}
