package Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//종이의 개수
public class p1780 {
    static int p[][];
    static int count_nag_one;
    static int count_zero;
    static int count_pos_one;

    static int paper(int n, int r, int c){
        int number =p[r][c];
        boolean check = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(p[r+i][c+j] != number){
                    check = false;
                    break;
                }
            }
            if(!check){
                break;
            }
        }
        int new_n= n/3;
        if(!check){
            paper(new_n, r, c);
            paper(new_n, r, c+new_n);
            paper(new_n, r, c+(2*new_n));
            paper(new_n, r+new_n, c);
            paper(new_n, r+new_n, c+new_n);
            paper(new_n, r+new_n, c+(2*new_n));
            paper(new_n, r+(2*new_n), c);
            paper(new_n, r+(2*new_n), c+new_n);
            paper(new_n, r+(2*new_n), c+(2*new_n));
        }else {
            if(number < 0){
                count_nag_one++;
            } else if (number>0) {
                count_pos_one++;
            }
            else{
                count_zero++;
            }
        }
        return 0;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        p = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                p[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        count_nag_one = 0;
        count_zero = 0;
        count_pos_one = 0;

        paper(n, 0, 0);
        System.out.println(count_nag_one);
        System.out.println(count_zero);
        System.out.print(count_pos_one);
    }
}
