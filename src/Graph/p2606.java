package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//바이러스
public class p2606 {
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

    static int countVirus(int v, int n){
        //너비우선 이용
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        boolean []visited = new boolean[n+1];
        Arrays.fill(visited, Boolean.FALSE);

        int w=0;
        while (!queue.isEmpty()){
            w = queue.remove();
            if(!visited[w]){
                count++;
                visited[w] = true;

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
        count--; //1번 컴퓨터 제외
        return count;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        graphLinkedList(N);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            addEdge(v1, v2);
        }
        System.out.print(countVirus(1, N));
    }
}
