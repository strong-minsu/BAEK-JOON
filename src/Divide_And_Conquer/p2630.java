package Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//색종이 만들기
public class p2630 {
    static int w;
    static int b;
    static int paper[][];

    static void count_paper(int n, int c, int r) {
        int color = paper[c][r];
        if(check_paper(n, c, r)){
            if(color == 0){
                w++;
            }
            else{
                b++;
            }
        }
        else {
            int new_n = n/2;
            count_paper(new_n, c, r);
            count_paper(new_n, c+new_n, r);
            count_paper(new_n, c, r+new_n);
            count_paper(new_n, c+new_n, r+new_n);
        }
        return;
    }

    static boolean check_paper(int n, int c, int r){
        //색이 다 같은지 검사..!
        int color = paper[c][r];
        for (int i = c; i < c+n; i++) {
            for (int j = r; j < r+n; j++) {
                if(color != paper[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        w = 0;
        b = 0;

        count_paper(N, 0, 0);
        System.out.println(w);
        System.out.print(b);
    }
}
