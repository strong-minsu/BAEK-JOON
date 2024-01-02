package Graph;

import java.io.*;
import java.util.*;

//택배 배송
public class p5972 {
    static int N, M;
    static ArrayList<Edge5972> map[];
    static boolean visited[];
    static int stover[];

    static PriorityQueue<Edge5972> priorityQueue = new PriorityQueue<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        stover = new int[N+1];
        for (int i = 0; i <= N; i++) {
            stover[i] = Integer.MAX_VALUE;
        }

        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            //양방향
            map[A].add(new Edge5972(B, C));
            map[B].add(new Edge5972(A, C));
        }

        priorityQueue.add(new Edge5972(1, 0));

        stover[1] = 0;
        while (!priorityQueue.isEmpty()){
            Edge5972 current = priorityQueue.poll();

            int currentVertex = current.vertex;

            if(visited[currentVertex]) continue;

            visited[currentVertex] = true;
            for (int i = 0; i < map[currentVertex].size(); i++) {
                Edge5972 next = map[currentVertex].get(i);

                int nextVertex = next.vertex;
                int nextValur = next.value;

                if(stover[nextVertex] > stover[currentVertex] + nextValur){
                    stover[nextVertex] = stover[currentVertex] + nextValur;
                    priorityQueue.add(new Edge5972(nextVertex, stover[nextVertex]));
                }
            }
        }
        System.out.print(stover[N]);
    }
}
class Edge5972 implements Comparable<Edge5972>{
    int vertex, value;
    Edge5972(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge5972 e){
        if(this.value > e.value){
            return 1;
        }
        return -1;
    }
}
