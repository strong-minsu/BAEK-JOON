package Graph;

import java.util.*;
import java.io.*;

//타임머신
public class p11657 {
    static int N, M;
    static LinkedList<Edge>[] city;
    static long[] distance;
    static long INF = Long.MAX_VALUE;
    static class Edge{
        int vertex, value;
        Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }
    }

    static boolean bellmanford(){
        Arrays.fill(distance, INF);
        distance[1] = 0;

        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;
            for (int j = 1; j < N+1; j++) {
                for (Edge edge: city[j]) {
                    if(distance[j] == INF){
                        break;
                    }
                    //현재까지 거리 INF아니고, 다음 위치 노드까지 거리가 현재 + 가중치인 경우 업뎃
                    if(distance[edge.vertex] > distance[j] + edge.value){
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
            for (int i = 1; i < N+1; i++) {
                for (Edge edge: city[i]) {
                    if(distance[i] == INF){
                        break;
                    }
                    //현재까지 거리 INF아니고, 다음 위치 노드까지 거리가 현재 + 가중치인 경우 업뎃
                    if(distance[edge.vertex] > distance[i] + edge.value){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new LinkedList[N+1];
        distance = new long[N+1];

        for (int i = 1; i < N+1; i++) {
            city[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            city[A].add(new Edge(B, C));
        }


        if(bellmanford()){
            for(int i=2; i<N+1; i++){
                if(distance[i] == INF){
                    sb.append("-1\n");
                }
                else {
                    sb.append(distance[i]+"\n");
                }
            }
        }
        else{
            sb.append("-1\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
