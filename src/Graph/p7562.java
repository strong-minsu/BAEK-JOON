package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//나이트의 이동
public class p7562 {
    static int N;
    static int board[][];
    static int count[][];
    static int []dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int []dy = {2, -2, 1, -1, 2, -2, 1, -1};
    static void chess(int x, int y) {
        boolean visited[][] = new boolean[N][N];

        Queue<int[]> queue = new LinkedList<>();
        int start[] = {x, y};
        queue.add(start);
        count[x][y] = 0;

        while (!queue.isEmpty()){
            int current[] = queue.remove();

            if(!visited[current[0]][current[1]]){
                visited[current[0]][current[1]] = true;

                for(int i=0; i<8; i++){
                    int next[] = {current[0]+dx[i], current[1]+dy[i]};

                    if(next[0]<N && next[0]>=0 && next[1]<N && next[1]>=0){
                        if(!visited[next[0]][next[1]]){
                            count[next[0]][next[1]] = count[current[0]][current[1]] +1;
                            queue.add(next);
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

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            count = new int[N][N];
            chess(x1, y1);

            sb.append(count[x2][y2]).append("\n");

        }
        System.out.print(sb);
    }
}
