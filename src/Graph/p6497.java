package Graph;

import java.io.*;
import java.util.*;

//전력난
public class p6497 {
    static int n, m, allCost;
    static int[] parent;
    static int [][] graph;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //여러개의 테스트 케이스가 들어온다. -> 그래프가 여러 번 들어올 수 있다는 ...
        while (true){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            //반복 중단 조건 0, 0
            if(m==0 && n==0){
                break;
            }
            parent = new int[200001];

            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            allCost = 0;
            graph = new int[n][3];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
                //간선 가중ㅊㅣ
                graph[i][2] = Integer.parseInt(st.nextToken());
                allCost += graph[i][2];
            }

            int cost = 0;
            Arrays.sort(graph, (o1, o2) -> {return o1[2] -o2[2];});
            for (int i = 0; i < n; i++) {
                if(findParent(graph[i][0]) != findParent(graph[i][1])){
                    cost += graph[i][2];
                    unionParent(graph[i][0], graph[i][1]);
                }
            }

            bw.write(allCost - cost + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

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
}
