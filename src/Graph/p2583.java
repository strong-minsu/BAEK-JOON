package Graph;

import java.util.*;
import java.io.*;

//영역 구하기
public class p2583 {
    static int N,M,K, width;
    static boolean[][] graphPaper;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int dfs(int x, int y){
        visited[x][y] = true;
        width++;
        for(int i=0; i<4; i++) {
            int[] next = {x+dx[i], y+dy[i]};

            if(next[0]< M && next[0]>=0 && next[1]< N && next[1] >= 0){
                //직사각형 영역이 아닌 곳인가, 방문한 곳인가
                if(!graphPaper[next[0]][next[1]] && !visited[next[0]][next[1]]){
                    dfs(next[0], next[1]);
                }
            }
        }
        return width;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graphPaper = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    graphPaper[k][j] = true;
                }
            }
        }

        visited = new boolean[M][N];
        int count = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                width = 0;
                if(!visited[i][j] && !graphPaper[i][j]){
                    count++;
                    priorityQueue.offer(dfs(i, j));
                }
            }
        }

        sb.append(count).append("\n");
        for (int i = 0; i < count; i++) {
            if(priorityQueue.size() == 1){
                sb.append(priorityQueue.poll());
            }
            else{
                sb.append(priorityQueue.poll()).append(" ");
            }

        }

        System.out.print(sb);
    }
}
