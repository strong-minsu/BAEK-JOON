package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//연결 요소의 개수
public class p11724 {
    static int N, M;
    static boolean []visited;
    static LinkedList<Integer>[] Graph;

    //그래프 생성 (노드 추가)
    public static void graphLinkedList(int v){
        Graph = new LinkedList[v+1];
        for(int i=1; i<v+1; i++){
            Graph[i] = new LinkedList<>();
        }
    }

    //간선 추가 (양방향)
    public static void addEdge(int v1, int v2){
        Graph[v1].add(v2);
        Graph[v2].add(v1);
    }

    public static void DFS(int V){
        //DFS 깊이 우선 탐색 : Stack이용
        Stack<Integer> stack = new Stack<>();
        stack.push(V);

        //방문하는 요소
        int w =0;

        //스택에 요소가 있을 때만 수행
        while(!stack.empty()) {
            w = stack.pop(); //가장 마지막에 들어간 노드 하나 빼기

            //방문하지 않았다면
            if(!visited[w]) {
                //방문한 상태로 저장
                visited[w] = true;

                //노드에 연결된 노드들 수만큼 반복
                for(int j=0; j<Graph[w].size(); j++) {
                    //노드 하나씩 가져와서
                    int g_node = Graph[w].get(j);

                    //방문 안한 상태면 스택에 넣어줌
                    if(!visited[g_node]) {
                        stack.push(g_node);
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graphLinkedList(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            addEdge(v1, v2);
        }
        int count=0;
        visited = new boolean[N + 1];
        for(int i=1; i<N+1; i++){
            if(!visited[i]){
                DFS(i); //bfs도 상관 없
                count++;
            }
        }
        System.out.print(count);
    }
}
