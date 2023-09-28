package Graph;

import java.util.*;
import java.io.*;

//트리의 부모 찾기

public class p11725 {
    //링크드 리스트로 그래프 구현
    static LinkedList<Integer>[] Graph;
    static int N, M;
    //그래프 생성
    public static void graphLinkedList(int v){
        Graph = new LinkedList[v+1];
        for(int i=1; i<v+1; i++){
            Graph[i] = new LinkedList<>();
        }
    }

    //그래프 노드 추가
    public static void addEdge(int v1, int v2){
        Graph[v1].add(v2);
        Graph[v2].add(v1);
    }

    public static int[] findParentsWithDFS (){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int []visited = new int[N + 1];
        visited[1] = 0;

        int node = 1;
        while (!stack.isEmpty()){
            node = stack.pop();
//            System.out.println("Node" + node);
            //노드에 연결된 노드들 수만큼 반복
                for(int j=0; j<Graph[node].size(); j++) {
                    //노드 하나씩 가져와서
                    int g_node = Graph[node].get(j);

                    //방문 안한 상태면 스택에 넣어줌
                    if (visited[g_node] == 0) {
                        visited[g_node] = node;
                        stack.push(g_node);
                    }
                }

        }
        return visited;
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //정점수
        N = Integer.parseInt(st.nextToken());
        //간선수
        M = N-1;
        //탐색을 시작할 정점의 번호 (루트가 항상 1)
        int V = 1;

        //그래프 생성
        graphLinkedList(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            addEdge(v1, v2);
        }


            int[] parents = findParentsWithDFS();

        for (int i = 2; i < N+1; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb);
    }

}
