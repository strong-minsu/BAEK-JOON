package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//파도반 수열
public class p9461 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        //int 범위를 넘을 수 있음...
        long [] N = new long[101];
        N[1] = 1;
        N[2] = 1;
        N[3] = 1;

        for(int i=4; i<101; i++){
            N[i] = N[i-2]+N[i-3];
        }

        for(int i=0; i<T; i++){
            int P = Integer.parseInt(br.readLine());
            sb.append(N[P]).append("\n");
        }

        System.out.print(sb);
    }
}
