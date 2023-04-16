package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//신입 사원
public class p1946 {
    public static void main(String[] args)throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int employment[][] = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                employment[j][0] = Integer.parseInt(st.nextToken());
                employment[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(employment, ((o1, o2) -> {
                return o1[0] - o2[0];
            }));

            int count = 1;
            int min = employment[0][1];
            for (int j = 1; j < N; j++) {
                if(employment[j][1]<min){
                    min = employment[j][1];
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
