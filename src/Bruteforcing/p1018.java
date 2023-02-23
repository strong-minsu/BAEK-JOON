package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//체스판 다시 칠하기
public class p1018 {
    static char WB[][] = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},};
    static char BW[][] = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},};;
    static char array[][];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new char[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M;j++){
                char c = s.charAt(j);
                array[i][j] =c;
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++){
                int countWB=0;
                int countBW=0;

                int n=0;
                for(int k=i; k<i+8; k++){
                    int m=0;
                    for(int l=j; l<j+8; l++){
                        if(WB[n][m] != array[k][l]){
                            countWB++;
                        }
                        if(BW[n][m] != array[k][l]){
                            countBW++;
                        }
                        m++;
                    }
                    n++;
                }


                int total = Math.min(countWB, countBW);
                if(total < min){
                    min = total;
                }
            }
        }
        System.out.print(min);
    }
}
