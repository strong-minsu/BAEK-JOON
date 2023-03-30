package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//케빈 베이컨의 6단계 법칙
public class p1389 {
    static int N, V;
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

    static int BFS (int v){
        int count[] = new int[N+1];
        boolean visited[] = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        int current = 0;
        while (!queue.isEmpty()){
            current = queue.poll();
            if(!visited[current]){
                visited[current] = true;
                for (int i = 0; i < Graph[current].size(); i++) {
                    int g_node = Graph[current].get(i);

                    if(!visited[g_node]) {
                        queue.add(g_node);
                        if(count[g_node] == 0){
                            count[g_node] = count[current] + 1;
                        }
                    }
                }
            }

        }

        int sum=0;
        for (int i = 1; i <= N; i++) {
            sum += count[i];
        }

        return sum;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graphLinkedList(N);

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            addEdge(v1, v2);
        }

        int index=0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N+1; i++) {
            int result = BFS(i);
            if(min > result){
                min = result;
                index = i;
            }
        }

        System.out.print(index);
    }
}
