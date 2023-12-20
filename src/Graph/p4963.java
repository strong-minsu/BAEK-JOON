package Graph;

import java.io.*;
import java.util.*;

//섬의 개수

public class p4963 {
    static int[][] graph;
    static boolean[][] visited;
    static int w,h;

    static int [] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int [] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static void dfs(int v1, int v2){
        Stack<int[]> stack = new Stack<>();
        int start[] = {v1, v2};

        stack.add(start);

        visited[v2][v1] = true;
        while (!stack.isEmpty()){
            int current[] = stack.pop();
                for (int i = 0; i < 8; i++) {
                    int next[] = {current[0] + dx[i], current[1] + dy[i]};
                    if (next[0] >= 0 && next[0] < w && next[1] >= 0 && next[1] < h) {
                        if(graph[next[1]][next[0]] == 1){
                            if (!visited[next[1]][next[0]]) {
                                stack.add(next);
                                visited[next[1]][next[0]] = true;
                            }
                        }
                    }

            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0){
                break;
            }

            graph = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    //방문한 적 없고, 땅이 있는 곳이면...?
                    if(!visited[i][j] && graph[i][j] == 1){
                        dfs(j, i);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");

        }
        System.out.print(sb);
    }
}
