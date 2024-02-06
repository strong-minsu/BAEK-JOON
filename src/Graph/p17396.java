package Graph;

import java.util.*;
import java.io.*;

//백도어
public class p17396 {
    static long INF = Long.MAX_VALUE;
    static int N, M;
    static boolean sight[];
    static LinkedList<Edge>[] map;
    static long[] distance;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sight = new boolean[N];

        map = new LinkedList[N];
        distance = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = new LinkedList<>();
            distance[i] = INF;

            int a = Integer.parseInt(st.nextToken());
            if(a == 0){
                // 0이면 방문 가능한 분기점이다.!
                sight[i] = true;
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            map[a].add(new Edge(b, t));
            map[b].add(new Edge(a, t));
        }

        distance[0] = 0;
        dijkstra();

        if(distance[N-1] == INF){
            bw.write(-1+"");
        }
        else{
            bw.write(distance[N-1]+"");
        }
        bw.flush();
        bw.close();
    }

    static void dijkstra(){
        PriorityQueue<Edge> priorityQueue  = new PriorityQueue<>();
        priorityQueue.offer(new Edge(0, 0));
        boolean visited[] = new boolean[N];

        while (!priorityQueue.isEmpty()){
            Edge current = priorityQueue.poll();
            int curNode = current.vertex;
            long curValue = current.value;

            //curValue > distance[curNode] << 이 조건도 필요한가..?
            if(visited[curNode] ) continue;

            visited[curNode] = true;
            for (int i = 0; i < map[curNode].size(); i++) {
                Edge next = map[curNode].get(i);
                int nextNode = next.vertex;
                long nextValue = next.value;

                if(!sight[nextNode] && nextNode != N-1) continue;
                if(distance[nextNode] > distance[curNode] + nextValue){
                    distance[nextNode] = distance[curNode] + nextValue;
                    priorityQueue.offer(new Edge(nextNode, distance[nextNode]));
                }
            }
        }
    }
    static class Edge implements Comparable<Edge>{
        int vertex;
        long value;
        Edge(int vertex, long value){
            this.vertex = vertex;
            this.value = value;
        }
        public int compareTo(Edge e){
            if(this.value > e.value){
                return 1;
            }
            return -1;
        }
    }

}
