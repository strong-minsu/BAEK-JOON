package Graph;

import java.io.*;
import java.util.*;

//안전 영역
public class p2468 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, maxHeight, result;
    static int[][] array;
    static boolean [][] visited;

    //bfs의 경우
    static void bfs(int x, int y, int height){
        Queue<int[]> queue = new LinkedList<>();

        //탐색 시작점
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int [] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int[] next = {current[0]+dx[i], current[1]+dy[i]};
                //다음 위치가 범위 안에 들어오는가
                if(next[0]<N && next[0]>=0 && next[1]<N && next[1] >= 0){
                    //최소 높이보다 높은가, 방문한 곳인가
                    if(array[next[0]][next[1]] > height && !visited[next[0]][next[1]]){
                        queue.add(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
        }
    }

    //dfs의 경우
    static void dfs(int x, int y, int height){
//        Stack<int[]> stack = new Stack<>();
//
//        //탐색 시작점
//        stack.push(new int[]{x, y});
//        visited[x][y] = true;
//
//        while (!stack.isEmpty()){
//            int [] current = stack.pop();
//
//            for (int i = 0; i < 4; i++) {
//                int[] next = {current[0]+dx[i], current[1]+dy[i]};
//                //다음 위치가 범위 안에 들어오는가
//                if(next[0]<N && next[0]>=0 && next[1]<N && next[1] >= 0){
//                    //최소 높이보다 높은가, 방문한 곳인가
//                    if(array[next[0]][next[1]] > height && !visited[next[0]][next[1]]){
//                        stack.push(next);
//                        visited[next[0]][next[1]] = true;
//                    }
//                }
//            }
//        }

        //스택 사용 없이 풀 경우
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int[] next = {x+dx[i], y+dy[i]};

            if(next[0]<N && next[0]>=0 && next[1]<N && next[1] >= 0){
                //최소 높이보다 높은가, 방문한 곳인가
                if(array[next[0]][next[1]] > height && !visited[next[0]][next[1]]){
                    dfs(next[0], next[1], height);
                }
            }
        }
        /**/
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        result = 0;
        maxHeight = Integer.MIN_VALUE;
        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int location = Integer.parseInt(st.nextToken());
                array[i][j] = location;

                if(location > maxHeight){
                    maxHeight = location;
                }
            }
        }

        for (int i = 0; i < maxHeight; i++) {
            int height = i;
            int count = 0;
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(!visited[j][k] && height<array[j][k]){
                        dfs(j, k, height);
                        count++;
                    }
                }
            }
            if(result < count){
                result = count;
            }
        }

        System.out.print(result);
    }
}
