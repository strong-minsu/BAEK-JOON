package Graph;

import java.io.*;
import java.util.*;

//도시 분할 계획
public class p1647 {
    static int N, M;
    static int[] parent;
    static int [][] graph;
    static int findParent(int x){
        if (parent[x] ==  x) return x;
        return parent[x] = findParent(parent[x]);
    }
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a > b) {parent[a] = b;}
        else {parent[b] = a;}

        return;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[100001];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        graph = new int[M][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            //간선 가중ㅊㅣ
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Arrays.sort(graph, (o1, o2) -> {return o1[2] -o2[2];});

        //마지막 가장 큰 비용 -> 다른 마을 하나
        int lastCost= 0;

        for (int i = 0; i < M; i++) {
            if(findParent(graph[i][0]) != findParent(graph[i][1])){
                answer += graph[i][2];
                unionParent(graph[i][0], graph[i][1]);
                lastCost = graph[i][2];
            }
        }

        System.out.print(answer - lastCost);

    }
}
