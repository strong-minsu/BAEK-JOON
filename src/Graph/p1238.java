package Graph;

import java.io.*;
import java.util.*;

//파티
//최단경로문제
public class p1238 {
    static class Edge implements Comparable<Edge>{
        int vertex, value;
        Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }
        @Override
        public int compareTo(Edge o) {
            if(this.value > o.value){
                return 1;
            }
            return -1;
        }
    }

    static int N, M, X;
    static ArrayList<Edge> town[];
    static ArrayList<Edge> reverse_town[];

    static int toX[];
    static int fromX[];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        town = new ArrayList[N+1];
        reverse_town = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            town[i] = new ArrayList<>();
            reverse_town[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            town[start].add(new Edge(end, time));
            reverse_town[end].add(new Edge(start, time));
        }

        //각 도시에서 X까지 걸리는 시간
        toX = dihkstra(town);
        //X에서 각 도시까지 걸리는 시간
        fromX = dihkstra(reverse_town);


        int result = Integer.MIN_VALUE;
        //가장 오래 걸리는 사람 구하기
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, toX[i] + fromX[i]);
        }

        System.out.print(result);
    }

    static  int[] dihkstra(ArrayList<Edge>[] town){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(X, 0));

        boolean vistited[] = new boolean[N+1];
        int Time[] = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            Time[i] = Integer.MAX_VALUE;
        }

        Time[X] = 0;
        while (!priorityQueue.isEmpty()){
            Edge current = priorityQueue.poll();
            int currentVertex = current.vertex;

            if(vistited[currentVertex]) continue;

            vistited[currentVertex] = true;
            for (int i = 0; i < town[currentVertex].size(); i++) {
                Edge next = town[currentVertex].get(i);
                int nextVertex = next.vertex;
                int nextValue = next.value;

                if(Time[nextVertex] > Time[currentVertex] + nextValue){
                    Time[nextVertex] = Time[currentVertex] + nextValue;
                    priorityQueue.add(new Edge(nextVertex, Time[nextVertex]));
                }
            }
        }
        return Time;
    }
}
