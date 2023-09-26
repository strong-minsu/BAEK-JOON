package Graph;
import java.util.*;
import java.io.*;

//쉬운 최단거리
class Location14940{
    int x;
    int y;
    Location14940(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class p14940 {
    static int N, M;
    static int [][] result;
    static boolean [][] visited;
    //방향 0=위, 1=왼쪽, 2=아래, 3=오른쪽
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    static void findDistanceWithBFS(int startX, int startY) {
        result[startX][startY] =0;

        Queue<Location14940> queue = new LinkedList<Location14940>();
        queue.add(new Location14940(startX, startY));
        visited[startX][startY] =true;

        while(!queue.isEmpty()) {
            Location14940 location = queue.poll();
            for(int i=0; i<4; i++) {
                int x = location.x + dx[i];
                int y = location.y + dy[i];
                if(0<=x && x< N && 0<=y && y<M) {
                    if(!visited[x][y] && result[x][y] != 0) {
                        queue.add(new Location14940(x, y));
                        visited[x][y] = true;
                        result[x][y] = result[location.x][location.y] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N][M];
        visited = new boolean[N][M];
        int startX=0, startY=0;
        int[][] graph = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // 시작점
                if(graph[i][j] == 2) {
                    startX = i;
                    startY = j;
                }

                if(graph[i][j] == 0) {
                    result[i][j] = 0;
                }else {
                    result[i][j] = -1;
                }
            }
        }

        findDistanceWithBFS(startX, startY);

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
