package Divide_And_Conquer;

import java.util.*;
import java.io.*;

// 별 찍기 - 10

public class p2447 {
    static boolean[][] checkStar;

    static void starChecker(int N, int r, int c){
//        주석이 더 시간 단축됨!
//        if(N == 1){
//            checkStar[r][c] = true;
//            return;
//        }
//        else{
//            int new_N = N/3;
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (!(i == 1 && j == 1)) {
//                        starChecker(new_N, r + i * (N / 3), c + j * (N / 3));
//                    }
//                }
//            }
//        }

        if(N == 3){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == 1 && j == 1){
                        checkStar[i+r][j+c] = false;
                    }
                    else{
                        checkStar[i+r][j+c] = true;
                    }
                }
            }
            return;
        }
        else{
            int new_N = N/3;
            starChecker(new_N, r, c);
            starChecker(new_N, r, c+new_N);
            starChecker(new_N, r, c+2*new_N);

            starChecker(new_N, r+new_N, c);
            starChecker(new_N, r+new_N, c+2*new_N);

            starChecker(new_N, r+2*new_N, c);
            starChecker(new_N, r+2*new_N, c+new_N);
            starChecker(new_N, r+2*new_N, c+2*new_N);
        }

    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        checkStar = new boolean[N][N];

        starChecker(N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(checkStar[i][j]){
                    bw.write("*");
                }
                else{
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

}
