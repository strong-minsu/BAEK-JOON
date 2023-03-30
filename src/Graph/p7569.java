package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
public class p7569 {
    static int tomato[][][];
    static int day[][][];
    static void count_day(int H, int N, int M){
        Queue<int[]> queue = new LinkedList<>();
        for(int k=0; k<H; k++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(tomato[k][i][j] == 1){
                        int []xyz = new int[3];
                        xyz[0] = k;
                        xyz[1] = i;
                        xyz[2] = j;
                        queue.add(xyz);
                    }
                }
            }
        }


        while (!queue.isEmpty()){
            int [] current = queue.remove();
            int XY [][] = {{current[0], current[1]-1, current[2]}, {current[0], current[1]+1, current[2]},
                    {current[0], current[1], current[2]-1},{current[0], current[1], current[2]+1},
                    {current[0]-1, current[1], current[2]}, {current[0]+1, current[1], current[2]}};
            for (int i = 0; i < 6; i++) {
                if(XY[i][0]<H && XY[i][0]>=0 && XY[i][1]<N && 0<=XY[i][1] && XY[i][2]<M && 0<=XY[i][2]){
                    if(tomato[XY[i][0]][XY[i][1]][XY[i][2]] == 0){
                        tomato[XY[i][0]][XY[i][1]][XY[i][2]] = 1;
                        queue.add(XY[i]);
                        day[XY[i][0]][XY[i][1]][XY[i][2]] = day[current[0]][current[1]][current[2]] + 1;
                    }
                }
            }
        }

        if (check(H, N, M)){
            int max=Integer.MIN_VALUE;
            for(int k=0; k< H; k++){
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if(max < day[k][i][j]){
                            max = day[k][i][j];
                        }
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
    static boolean check(int H, int N, int M){
        for(int k=0; k< H; k++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(tomato[k][i][j] == 0){
                        return false;
                    }
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
        int H = Integer.parseInt(st.nextToken());//쌓아올려지는 상자의 수

        tomato = new int[H][N][M];
        day = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomato[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        if(check(H, N, M)){
            System.out.print(0);
        }else{
            count_day(H, N, M);
        }
    }
}
