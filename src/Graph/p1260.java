package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//DFS와 BFS
//graph 탐색 문제의 기본!
public class p1260 {
    static LinkedList<Integer>[] Graph;

    //LinkedList 로 graph 생성, 초기화
    public static void graphLinkedList(int v){
        Graph = new LinkedList[v+1];
        for(int i=1; i<v+1; i++){
            Graph[i] = new LinkedList<>();
        }
    }

    //노드 추가 (양방향)
    public static void addEdge(int v1, int v2){
        Graph[v1].add(v2);
        Graph[v2].add(v1);
    }

    public static void DFS(int V, int N){
        //DFS 깊이 우선 탐색 : Stack이용
        Stack<Integer> stack = new Stack<>();
        stack.push(V);
        //방문여부 검사
        boolean []visited = new boolean[N + 1];

        //우선 모두 false로 초기화
        Arrays.fill(visited, Boolean.FALSE);

        //방문하는 요소
        int w =0;

        //스택에 요소가 있을 때만 수행
        while(!stack.empty()) {
            w = stack.pop(); //가장 마지막에 들어간 노드 하나 빼기

            //방문하지 않았다면
            if(!visited[w]) {
                //노드 출력
                System.out.print(w + " ");
                //방문한 상태로 저장
                visited[w] = true;

                //정점 번호가 작은 것 먼저 방문해야하므로 FILO인 스택에서는 내림차순으로 정렬
                Collections.sort(Graph[w], Collections.reverseOrder());

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

    public static void BFS(int V, int N){
        //BFS 너비 우선 탐색 : Queue이용
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        //방문여부 검사
        boolean []visited = new boolean[N + 1];

        //우선 모두 false로 초기화
        Arrays.fill(visited, Boolean.FALSE);

        //방문하는 요소
        int w =0;

        //큐에 요소가 있을 때만 수행
        while(!queue.isEmpty()) {
            w = queue.remove(); //가장 처음에 들어간 노드 하나 빼기

            //방문하지 않았다면
            if(!visited[w]) {
                //노드 출력
                System.out.print(w + " ");
                //방문한 상태로 저장
                visited[w] = true;

                //정점 번호가 작은 것 먼저 방문해야하므로 FIFO인 큐에서는 오름차순으로 정렬
                Collections.sort(Graph[w]);

                //노드에 연결된 노드들 수만큼 반복
                for(int j=0; j<Graph[w].size(); j++) {
                    //노드 하나씩 가져와서
                    int g_node = Graph[w].get(j);

                    //방문 안한 상태면 큐에 넣어줌
                    if(!visited[g_node]) {
                        queue.add(g_node);
                    }
                }
            }
        }

    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점수
        int N = Integer.parseInt(st.nextToken());
        //간선수
        int M = Integer.parseInt(st.nextToken());
        //탐색을 시작할 정점의 번호
        int V = Integer.parseInt(st.nextToken());

        //그래프 생성
        graphLinkedList(N);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            addEdge(v1, v2);
        }

        DFS(V, N);
        System.out.println();
        BFS(V, N);

    }
}
