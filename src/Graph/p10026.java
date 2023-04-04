package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//적록색약
public class p10026 {
    static int N;
    static int [][] Grid_RGB;
    static int [][] Grid_RGWB;
    static boolean[][] check;
    static void Search (boolean rgb, int y, int x, int n) {
        check[y][x] = true;

        int next[][] = {{x+1, y}, {x-1, y}, {x, y+1}, {x, y-1}};
        for (int i = 0; i < 4; i++) {
            boolean range = next[i][0]>=0 && next[i][0]<N && next[i][1]>=0 &&next[i][1]<N;
            if(range && !check[next[i][1]][next[i][0]]){
                if(rgb){
                    Grid_RGB[y][x] = 0;
                    if(Grid_RGB[next[i][1]][next[i][0]] == n) {
                        Grid_RGB[next[i][1]][next[i][0]] = 0;
                        Search(true, next[i][1], next[i][0], n);
                    }
                }
                else{
                    Grid_RGWB[y][x] = 0;
                    if(Grid_RGWB[next[i][1]][next[i][0]] == n) {
                        Grid_RGWB[next[i][1]][next[i][0]] = 0;
                        Search(false, next[i][1], next[i][0], n);
                    }
                }

            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        Grid_RGB = new int[N][N];
        Grid_RGWB = new int[N][N];

        //RGB인 경우 R = 1, G = 2, B = 3 / RGW인 경우 R, G = 1,
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if(s.charAt(j)=='R'){
                    Grid_RGB[i][j] = 1;
                    Grid_RGWB[i][j] = 1;
                }
                else if(s.charAt(j)=='G'){
                    Grid_RGB[i][j] = 2;
                    Grid_RGWB[i][j] = 1;
                }
                else {
                    Grid_RGB[i][j] = 3;
                    Grid_RGWB[i][j] = 2;
                }
            }
        }

        check = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!check[i][j]){
                    if(Grid_RGB[i][j] == 1){
                        Search(true, i, j, 1);
                    }
                    else if(Grid_RGB[i][j] == 2){
                        Search(true, i, j, 2);
                    }
                    else{
                        Search(true, i, j, 3);
                    }
                    count++;
                }
            }
        }
        sb.append(count).append(" ");

        check = new boolean[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!check[i][j]){
                    if(Grid_RGWB[i][j] == 1){
                        Search(false, i, j, 1);
                    }
                    else{
                        Search(false, i, j, 2);
                    }
                    count++;
                }
            }
        }
        sb.append(count);

        System.out.print(sb);
    }
}
