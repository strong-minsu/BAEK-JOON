package Backtracking;

import java.util.*;
import java.io.*;

//N-Queen
public class p9663 {
    static int N;
    static int[] chessBoard;
    static int result;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        chessBoard = new int[N];
        result = 0;

        backtracking(0);
        System.out.print(result);
    }

    static void backtracking(int depth){
        //자리를 모두 선택할 수 있는 경우 결과++;
        if(depth == N){
            result++;
            return;
        }

        //인덱스를 '열'이라고 생각하고 각 원소를 '행'이라고 생각
        // 0 1 2 -> 인덱스 열
        // 0 1 2 -> 행
        for (int i = 0; i < N; i++) {
            //depth열에 i행 위치에 퀸을 두는 경우
            chessBoard[depth] = i;
            if(checkQueen(depth)){
                backtracking(depth+1);
            }
        }

    }

    //체스판 검사
    static boolean checkQueen(int col){
        for (int i = 0; i < col; i++) {
            //인덱스는 모두 다르므로, 행이 같은 것만 비교하면 됨
            if(chessBoard[i] == chessBoard[col]){
                return false;
            }
            //열과 행의 차의 절대값이 같은 경우 같은 대각선에 위치함
            else if(Math.abs(col-i) == Math.abs(chessBoard[col] - chessBoard[i])){
                return false;
            }
        }
        return true;
    }
}
