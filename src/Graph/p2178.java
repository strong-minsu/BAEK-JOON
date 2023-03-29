package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로 탐색
public class p2178 {
    static int [][]maze;
    static int [][]check_maze;
    static void BFS (int N, int M){
        check_maze[1][1] = 1;
        int x = 1;
        int y = 1;

        int p[] = {1, 1};
        Queue<int[]> xy = new LinkedList<>();
        xy.add(p);

        while (!xy.isEmpty()){
            int []current = xy.poll();
            int [][] move = {{current[0]+1, current[1]}, {current[0]-1, current[1]},
                            {current[0], current[1]+1}, {current[0], current[1]-1}};

            for (int i = 0; i < 4; i++) {
                if(move[i][0] > 0 && move[i][0] < M+1 && move[i][1] > 0 && move[i][1] < N+1){
                    int next[] = new int[2] ;
                    next = move[i];
                    if(maze[next[1]][next[0]] == 1){
                        if(check_maze[next[1]][next[0]] == 0){
                            check_maze[next[1]][next[0]] = check_maze[current[1]][current[0]]+1;
                            xy.add(next);
                        }
                    }
                }
            }
        }

    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //0,0을 1,1로
        maze = new int[N+1][M+1];
        check_maze = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(),"");
            String str = st.nextToken();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = str.charAt(j-1) -'0';
            }
        }
        BFS(N, M);
        System.out.print(check_maze[N][M]);
    }
}
