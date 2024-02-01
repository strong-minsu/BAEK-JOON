package Graph;

import java.util.*;
import java.io.*;

//웜홀
public class p1865 {
    static int n, m, w, tc;
    static LinkedList<Edge>[] graph;
    static int[] distance;

    static int INF = 900000000;
    static class Edge{
        int vertex, value;
        Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }
    }

    static boolean BellmanFord(int start){
        Arrays.fill(distance, INF);
        distance[start] = 0;

        boolean update = false;

        //n번 반복
        for (int i = 1; i < n; i++) {
            update = false;
            for (int j = 1; j < n+1 ; j++) {
                for (Edge edge: graph[j]) {
                    //현재까지 거리 INF아니고, 다음 위치 노드까지 거리가 현재 + 가중치인 경우 업뎃
                    if(distance[j] != INF && distance[edge.vertex] > distance[j] + edge.value){
                        distance[edge.vertex] = distance[j] + edge.value;
                        update = true;
                    }
                }
            }
            if(!update){
                break;
            }
        }

        if(update){
            for (int i = 1; i < n+1; i++) {
                for (Edge edge: graph[i]) {
                    if(distance[i] != INF && distance[edge.vertex] > distance[i] + edge.value){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String [] agrs)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new LinkedList[n+1];

            for (int l = 1; l < n+1; l++) {
                graph[l] = new LinkedList<>();
            }

            distance = new int[n+1];

            //도로의 정보 => 양방향
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[s].add(new Edge(e, t));
                graph[e].add(new Edge(s, t));
            }

            //웜홀의 정보 => 단방향
            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[s].add(new Edge(e, t*(-1)));
            }

            boolean flageMinusCycle = false;
            for (int j = 1; j < n+1; j++) {
                if(!BellmanFord(j)){
                    flageMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if(!flageMinusCycle){
                sb.append("NO\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
