package Dynamic_Programming;

import java.util.*;
import java.io.*;

//내려가기
public class p2096 {
    static int N;
    static int[][] maxDp;
    static int[][] minDp;
    static int[][] array;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        array = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxDp = new int[N+1][3];
        minDp = new int[N+1][3];

        for (int i = 0; i < 3; i++) {
            maxDp[1][i] = array[1][i];
            minDp[1][i] = array[1][i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0){
                    maxDp[i][j] = Math.max(maxDp[i-1][j], maxDp[i-1][j+1]) + array[i][j];
                    minDp[i][j] = Math.min(minDp[i-1][j], minDp[i-1][j+1]) + array[i][j];
                }
                else if(j==1){
                    maxDp[i][j] = Math.max(maxDp[i-1][j],Math.max(maxDp[i-1][j+1], maxDp[i-1][j-1])) + array[i][j];
                    minDp[i][j] = Math.min(minDp[i-1][j],Math.min(minDp[i-1][j+1], minDp[i-1][j-1])) + array[i][j];
                }
                else{
                    maxDp[i][j] = Math.max(maxDp[i-1][j], maxDp[i-1][j-1]) + array[i][j];
                    minDp[i][j] = Math.min(minDp[i-1][j], minDp[i-1][j-1]) + array[i][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(maxDp[N][0], Math.max(maxDp[N][1], maxDp[N][2]))).append(" ");
        sb.append(Math.min(minDp[N][0], Math.min(minDp[N][1], minDp[N][2])));
        System.out.print(sb);
    }
}
