package Graph;

import java.io.*;
import java.util.*;

//최단경로
public class p1753 {
    static int V, E, K;
    static ArrayList<Edge1753> list[];
    static int D[];
    static boolean visited[];
    static PriorityQueue<Edge1753> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        //그래프 생성
        list = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        //거리 배열 생성 (초기 값 int < MAX로 설정)
        D = new int[V+1];
        for (int i = 0; i <= V ; i++) {
            D[i] = Integer.MAX_VALUE;
        }

        //방문 배열 생성
        visited = new boolean[V+1];

        //입력 받아서 가중치 그래프 채우기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            //u에서 v까지 w만큼의 가중치
            list[u].add(new Edge1753(v, w));
        }

        //K (시작 노드 우선 순위 큐에 추가)
        priorityQueue.add(new Edge1753(K,0));

        D[K] = 0;
        while (!priorityQueue.isEmpty()){
            Edge1753 current = priorityQueue.poll();

            int currentVertex = current.vertex;

            //이미 방문한 경우 큐에 넣지 않음
            if(visited[currentVertex]) continue;

            //방문 체크
            visited[currentVertex] = true;

            for (int i = 0; i < list[currentVertex].size(); i++) {
                Edge1753 next = list[currentVertex].get(i);

                int nextVertex = next.vertex;
                int nextValue = next.value;

                //최소 거리로 업데이트
                if(D[nextVertex] > D[currentVertex]+nextValue){
                    D[nextVertex] = D[currentVertex]+nextValue;
                    priorityQueue.add(new Edge1753(nextVertex, D[nextVertex]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if(visited[i]){
                sb.append(D[i]).append("\n");
            }
            else {
                sb.append("INF\n");
            }
        }
        System.out.print(sb);
    }
}

class Edge1753 implements Comparable<Edge1753>{
    //우선 순위 비교를 위해 Comparable interface를 implements함!
    int vertex, value;
    Edge1753(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    //인터페이스 상속시 반드시 오버라이딩 필요
    public int compareTo(Edge1753 e){
        if(this.value > e.value){
            return 1;
        }
        return -1;
    }
}