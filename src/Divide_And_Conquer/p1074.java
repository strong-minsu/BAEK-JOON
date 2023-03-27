package Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Z
public class p1074 {
    static int N;
    static int count;

    static void Z (int size, int r, int c){
        if(size == 1) {
            //죵료
            return;
        }
//		1사분면
        if(r < size/2 && c < size/2) {
            Z(size/2, r, c);
        }
//		2사분면
        else if(r < size/2 && c >= size/2) {
            count += (size/2)*(size/2);
            Z(size/2, r, c-(size/2));
        }
//		3사분면
        else if(r >= size/2 && c < size/2) {
            count += ((size/2)*(size/2)) * 2;
            Z(size/2, r-(size/2), c);
        }
//		4사분면
        else {
            count += ((size/2)*(size/2)) * 3;
            Z(size/2, r-(size/2), c-(size/2));
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        count = 0;

        Z((int)Math.pow(2, N), r, c);

        System.out.print(count);
    }
}
