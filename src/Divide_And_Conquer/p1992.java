package Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;

//쿼드트리
public class p1992 {
    static int [][]video;
    static void QuadTree(int r, int c, int size){
        int number = video[r][c];
        if(check(r, c, size)){
            System.out.print(number);
            return;
        }
        else{
            System.out.print("(");
            int newSize = size/2;
            QuadTree(r, c, newSize);
            QuadTree(r, c+newSize, newSize);
            QuadTree(r+newSize, c, newSize);
            QuadTree(r+newSize, c+newSize, newSize);
            System.out.print(")");
        }
    }

    static boolean check(int r, int c, int size){
        int k = video[r][c];
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if(k != video[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = s.charAt(j) - '0';
            }
        }
        QuadTree(0, 0, N);
    }
}
