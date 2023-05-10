package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//서강근육맨
public class p20300 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long []n = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            n[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(n);

        long M=-1;

        if(N%2==1){
            for (int i = 0; i < N/2; i++){
                M = Math.max(M, n[i]+n[N-2-i]);
            }
            if(M < n[N-1]){
                M = n[N-1];
            }
        }
        else{
            for (int i = 0; i < N/2; i++){
                M = Math.max(M, n[i]+n[N-1-i]);
            }
        }
        System.out.print(M);
    }
}
