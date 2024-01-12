package Graph;

import java.util.*;
import java.io.*;

//다리 만들기
public class p2146 {
    static int N, count, min;
    static boolean[][] map;
    static int[][] continent;
    static boolean[][] visited;
    static boolean[][] bridgeVisited;
    static Queue<int[]> queue;

    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static void checkContinent(int x, int y){
        visited[x][y] = true;
        continent[x][y] = count;
        for (int i = 0; i < 4; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            if(nextX>=0 && nextX<N && nextY>=0 && nextY<N){
                if(!visited[nextX][nextY] && map[nextX][nextY]){
                    checkContinent(nextX, nextY);
                }
            }

        }

    }
    static void countBridge(int startX, int startY, int startContinent){
        //시작점 x, y
        boolean [][] visitedOcean = new boolean[N][N];
        queue = new LinkedList<>();

        visitedOcean[startX][startY] = true;
        queue.add(new int[] {startX, startY});

        while (!queue.isEmpty()){
            int current[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next[] = {current[0]+dx[i], current[1]+dy[i]};

                if(next[0]>=0 && next[0]<N && next[1]>=0 && next[1]<N){
                    if(!visitedOcean[next[0]][next[1]]){
                        visitedOcean[next[0]][next[1]] = true;
                        if(continent[next[0]][next[1]] != 0){
                            if(continent[next[0]][next[1]] != startContinent){
                                int result  = Math.abs(next[0]-startX) + Math.abs(next[1] - startY);
                                min = Math.min(result, min);
                            }
                        }
                        else if(continent[next[0]][next[1]] == 0) {
                            queue.add(new int [] {next[0], next[1]});
                        }
                    }
                }

            }
        }

    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        continent = new int[N][N];
        visited = new boolean[N][N];
        bridgeVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1){
                    map[i][j] = true;
                }
            }
        }

        //dfs 카운트로 대륙 탐색
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j]){
                    count++;
                    checkContinent(i, j);
                }
            }
        }

        //대륙의 테두리인 경우만 bfs로 바다 거리 탐색
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int continentLevel= continent[i][j];
                //현재 대륙인 경우
                if(continentLevel != 0){

                    //4개 다음 위치 중에 0인 부분이 있는 경우
                    for (int k = 0; k < 4; k++) {
                        int nextX = i+dx[k];
                        int nextY = j+dy[k];

                        if(nextX>=0 && nextX<N && nextY>=0 && nextY<N){
                            //다음 위치가 바다인 경우 + 테두리 방문 체크
                            if(!map[nextX][nextY] && !bridgeVisited[nextX][nextY]){
                                bridgeVisited[nextX][nextY] = true;
                                countBridge(nextX, nextY, continentLevel);
                            }
                        }
                    }
                }

            }
        }

        System.out.print(min);
    }
}
