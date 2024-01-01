package Graph;

import java.io.*;
import java.util.*;

//최소비용 구하기
public class p1916 {
    static int N, M, A, B;
    static ArrayList<Edge1916> [] city;
    static boolean visited[];
    static int cost[];

    static PriorityQueue<Edge1916> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        city = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            city[i] = new ArrayList<>();
        }

        cost = new int[N+1];
        for (int i = 0; i <= N ; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            city[a].add(new Edge1916(b, w));
        }

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        priorityQueue.add(new Edge1916(A, 0));

        cost[A] = 0;
        while (!priorityQueue.isEmpty()){
            Edge1916 current  = priorityQueue.poll();

            int currentVertex = current.vertex;

            if(visited[currentVertex]) continue;

            visited[currentVertex] = true;

            for (int i = 0; i < city[currentVertex].size(); i++) {
                Edge1916 next = city[currentVertex].get(i);

                int nextVertex = next.vertex;
                int nextValue = next.value;

                if(cost[nextVertex] > cost[currentVertex]+ nextValue){
                    cost[nextVertex] = cost[currentVertex]+ nextValue;
                    priorityQueue.add(new Edge1916(nextVertex, cost[nextVertex]));
                }
            }
        }
        System.out.print(cost[B]);
    }
}

class Edge1916 implements Comparable<Edge1916>{
    int vertex, value;
    Edge1916(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    //인터페이스 상속시 반드시 오버라이딩 필요
    public int compareTo(Edge1916 e){
        if(this.value > e.value){
            return 1;
        }
        return -1;
    }
}