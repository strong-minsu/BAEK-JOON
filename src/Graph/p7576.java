package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
public class p7576 {
    static int tomato[][];
    static int day[][];
    static void count_day(int N, int M){
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomato[i][j] == 1){
                    int []xy = new int[2];
                    xy[0] = i;
                    xy[1] = j;
                    queue.add(xy);
                }
            }
        }

        while (!queue.isEmpty()){
            int [] current = queue.remove();
            int XY [][] = {{current[0]-1, current[1]}, {current[0]+1, current[1]},
                    {current[0], current[1]-1},{current[0], current[1]+1}};
            for (int i = 0; i < 4; i++) {
                if(XY[i][0]<N && 0<=XY[i][0] && XY[i][1]<M && 0<=XY[i][1]){
                    if(tomato[XY[i][0]][XY[i][1]] == 0){
                        tomato[XY[i][0]][XY[i][1]] = 1;
                        queue.add(XY[i]);
                        day[XY[i][0]][XY[i][1]] = day[current[0]][current[1]] + 1;
                    }
                }
            }
        }

        if (check(N, M)){
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(max < day[i][j]){
                        max = day[i][j];
                    }
                }
            }
            System.out.print(max);
        }
        else {
            System.out.print(-1);
            return;
        }
    }

    //상자안에 토마토가 다 익었는지 체크
    static boolean check(int N, int M){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomato[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());//상자의 가로
        int N = Integer.parseInt(st.nextToken());//상자의 세로

        tomato = new int[N][M];
        day = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(check(N, M)){
            System.out.print(0);
        }else{
            count_day(N, M);
        }
    }
}
